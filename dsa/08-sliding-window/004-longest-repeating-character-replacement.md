# 4. Longest Repeating Character Replacement

**LeetCode 424** · 🟡 Medium · Pattern: **Variable window + max frequency**
🔗 Solve it here: [https://leetcode.com/problems/longest-repeating-character-replacement/](https://leetcode.com/problems/longest-repeating-character-replacement/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/004-longest-repeating-character-replacement.html](https://amitxaidev.github.io/dsa/08-sliding-window/004-longest-repeating-character-replacement.html)

## The problem, in short

You may change at most k characters of an uppercase string. Return the longest substring that can be made of one repeated letter.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A window is fine when (window length − count of its most common letter) ≤ k.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep letter counts for the window.

</details>

<details>
<summary>💡 Hint 3</summary>

maxFreq never needs to decrease — the answer only grows when maxFreq grows.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Expand right, update counts and the highest count seen. If the window needs more than k changes, move left by one (the window slides instead of shrinking). The final window size is the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFreq = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            maxFreq = Math.max(maxFreq, ++count[s.charAt(r) - 'A']);
            if (r - left + 1 - maxFreq > k) {      // too many letters to change
                count[s.charAt(left) - 'A']--;
                left++;
            }
            best = Math.max(best, r - left + 1);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(26).

## Common mistake

⚠️ Recomputing the true max frequency every time you shrink — correct but unnecessary; the stale maximum still gives the right answer.

---

⬅️ [Previous: Longest Substring Without Repeating Characters](./003-longest-substring-without-repeating-characters.md) · [📋 Sliding Window list](./README.md) · [Next: Permutation in String](./005-permutation-in-string.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
