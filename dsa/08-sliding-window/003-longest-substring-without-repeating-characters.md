# 3. Longest Substring Without Repeating Characters

**LeetCode 3** · 🟡 Medium · Pattern: **Variable window**

## The problem, in short

Return the length of the longest substring with no repeated characters.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/003-longest-substring-without-repeating-characters.html](https://amitxaidev.github.io/dsa/08-sliding-window/003-longest-substring-without-repeating-characters.html)

## Understanding

**Really asking:** the longest stretch with no repeated letter.

**Why this works:** grow the window to the right; when a letter repeats, jump the left edge past its previous position.

**Example:** "abcabcbb"
```text
"abc" length 3
next 'a' repeats → left moves past first 'a' → "bca"
… best stays 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Grow the window on the right; when a repeat appears, shrink from the left.

</details>

<details>
<summary>💡 Hint 2</summary>

Remember the last index where each character was seen to jump the left edge directly.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep last[c] = latest index of c. When s[r] was seen at or after left, move left to last[c] + 1. The window left..r always has unique characters; record its length.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int left = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            left = Math.max(left, last[c] + 1);   // jump past the previous copy
            last[c] = r;
            best = Math.max(best, r - left + 1);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(charset) — 128 for ASCII.

## Common mistake

⚠️ Moving left backwards when the previous occurrence is before the window. Use max(left, last + 1).

---

⬅️ [Previous: Contains Duplicate II](./002-contains-duplicate-ii.md) · [📋 Sliding Window list](./README.md) · [Next: Longest Repeating Character Replacement](./004-longest-repeating-character-replacement.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
