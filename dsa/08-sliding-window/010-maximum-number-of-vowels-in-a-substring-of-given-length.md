# 10. Maximum Number of Vowels in a Substring of Given Length

**LeetCode 1456** · 🟡 Medium · Pattern: **Fixed window**
🔗 Solve it here: [https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/010-maximum-number-of-vowels-in-a-substring-of-given-length.html](https://amitxaidev.github.io/dsa/08-sliding-window/010-maximum-number-of-vowels-in-a-substring-of-given-length.html)

## The problem, in short

Return the most vowels found in any substring of length k.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count vowels in the first window.

</details>

<details>
<summary>💡 Hint 2</summary>

When sliding, add 1 if the incoming char is a vowel and subtract 1 if the outgoing char is.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Standard fixed-size sliding window with a running vowel count.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxVowels(String s, int k) {
        int count = 0, best = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;
            if (i >= k && isVowel(s.charAt(i - k))) count--;   // char leaving the window
            best = Math.max(best, count);
        }
        return best;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using s.substring for each window, which copies k characters each time.

---

⬅️ [Previous: Fruit Into Baskets](./009-fruit-into-baskets.md) · [📋 Sliding Window list](./README.md) · [Next: Maximum Points You Can Obtain from Cards](./011-maximum-points-you-can-obtain-from-cards.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
