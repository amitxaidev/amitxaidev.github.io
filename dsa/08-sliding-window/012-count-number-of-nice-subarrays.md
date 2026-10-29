# 12. Count Number of Nice Subarrays

**LeetCode 1248** · 🟡 Medium · Pattern: **atMost(k) − atMost(k−1)**
🔗 Solve it here: [https://leetcode.com/problems/count-number-of-nice-subarrays/](https://leetcode.com/problems/count-number-of-nice-subarrays/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/012-count-number-of-nice-subarrays.html](https://amitxaidev.github.io/dsa/08-sliding-window/012-count-number-of-nice-subarrays.html)

## The problem, in short

Count subarrays that contain exactly k odd numbers.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

"Exactly k" is hard to slide directly. "At most k" is easy.

</details>

<details>
<summary>💡 Hint 2</summary>

exactly(k) = atMost(k) − atMost(k − 1).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

atMost(k) counts subarrays with at most k odd numbers: expand right, shrink while odds > k, and add the window length (every subarray ending at r and starting in the window qualifies). Subtract the two results.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, odds = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1) odds++;
            while (odds > k) {
                if (nums[left] % 2 == 1) odds--;
                left++;
            }
            count += r - left + 1;   // subarrays ending at r
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Adding 1 per valid window instead of the window length — you'd count only one subarray per right end.

---

⬅️ [Previous: Maximum Points You Can Obtain from Cards](./011-maximum-points-you-can-obtain-from-cards.md) · [📋 Sliding Window list](./README.md) · [Next: Minimum Window Substring](./013-minimum-window-substring.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
