# 10. Longest Palindromic Substring

**LeetCode 5** · 🟡 Medium · Pattern: **Expand around centre**

## The problem, in short

Return the longest substring that is a palindrome.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/longest-palindromic-substring/](https://leetcode.com/problems/longest-palindromic-substring/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/010-longest-palindromic-substring.html](https://amitxaidev.github.io/dsa/11-strings/010-longest-palindromic-substring.html)

## Understanding

**Really asking:** the longest piece that is a palindrome.

**Why this works:** every palindrome grows out from a centre (one letter, or a gap between two). Try every centre and expand while both sides match.

**Example:** "babad"
```text
centre 'a' (index 1): "bab" length 3
centre 'b' (index 2): "aba" length 3
answer "bab"
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Every palindrome has a centre: one character (odd length) or a gap between two (even length).

</details>

<details>
<summary>💡 Hint 2</summary>

There are 2n − 1 centres. Expand outward from each while the ends match.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each index try both centre types, expand while s[l] == s[r], and keep the longest span.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private int start = 0, maxLen = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // odd length
            expand(s, i, i + 1);   // even length
        }
        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > maxLen) {   // the palindrome is l+1 .. r-1
            maxLen = r - l - 1;
            start = l + 1;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(1).

## Common mistake

⚠️ Only expanding around single characters, which misses even-length palindromes like "abba".

---

⬅️ [Previous: Reverse Words in a String](./009-reverse-words-in-a-string.md) · [📋 Strings list](./README.md) · [Next: String to Integer (atoi)](./011-string-to-integer-atoi.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
