# 6. Longest Palindrome

**LeetCode 409** · 🟢 Easy · Pattern: **Frequency count**
🔗 Solve it here: [https://leetcode.com/problems/longest-palindrome/](https://leetcode.com/problems/longest-palindrome/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/006-longest-palindrome.html](https://amitxaidev.github.io/dsa/11-strings/006-longest-palindrome.html)

## The problem, in short

Using the letters of s (case-sensitive), return the length of the longest palindrome you can build.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Letters used in pairs can go on both sides.

</details>

<details>
<summary>💡 Hint 2</summary>

One letter with an odd count can sit in the middle.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count each character. Add count / 2 * 2 for every character, and add 1 at the end if any count was odd.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) count[c]++;
        int len = 0;
        boolean odd = false;
        for (int c : count) {
            len += c / 2 * 2;          // pairs
            if (c % 2 == 1) odd = true;
        }
        return odd ? len + 1 : len;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(charset).

## Common mistake

⚠️ Adding every odd count fully — only one odd letter can be in the middle.

---

⬅️ [Previous: Isomorphic Strings](./005-isomorphic-strings.md) · [📋 Strings list](./README.md) · [Next: Ransom Note](./007-ransom-note.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
