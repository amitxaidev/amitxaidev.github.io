# 11. Maximum Points You Can Obtain from Cards

**LeetCode 1423** · 🟡 Medium · Pattern: **Window on the complement**
🔗 Solve it here: [https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/011-maximum-points-you-can-obtain-from-cards.html](https://amitxaidev.github.io/dsa/08-sliding-window/011-maximum-points-you-can-obtain-from-cards.html)

## The problem, in short

Cards are in a row. Take exactly k cards, each from either the left or right end. Maximise the sum of taken cards.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Whatever you take, the cards left behind form a contiguous block of length n − k.

</details>

<details>
<summary>💡 Hint 2</summary>

Maximising what you take = minimising the sum of that middle block.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Find the minimum-sum window of size n - k with a fixed sliding window, and subtract it from the total.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, w = n - k, total = 0;
        for (int x : cardPoints) total += x;
        int sum = 0;
        for (int i = 0; i < w; i++) sum += cardPoints[i];
        int minWindow = sum;
        for (int i = w; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - w];
            minWindow = Math.min(minWindow, sum);
        }
        return total - minWindow;   // cards taken = everything except the middle block
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Trying greedy "take the bigger end each time" — it fails when a big card hides behind a small one.

---

⬅️ [Previous: Maximum Number of Vowels in a Substring of Given Length](./010-maximum-number-of-vowels-in-a-substring-of-given-length.md) · [📋 Sliding Window list](./README.md) · [Next: Count Number of Nice Subarrays](./012-count-number-of-nice-subarrays.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
