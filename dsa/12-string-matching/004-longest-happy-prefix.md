# 4. Longest Happy Prefix

**LeetCode 1392** · 🔴 Hard · Pattern: **LPS array**
🔗 Solve it here: [https://leetcode.com/problems/longest-happy-prefix/](https://leetcode.com/problems/longest-happy-prefix/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/004-longest-happy-prefix.html](https://amitxaidev.github.io/dsa/12-string-matching/004-longest-happy-prefix.html)

## The problem, in short

A "happy prefix" is a non-empty prefix that is also a suffix, but not the whole string. Return the longest one, or "".

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

This is exactly what the KMP failure function computes.

</details>

<details>
<summary>💡 Hint 2</summary>

The answer's length is lps[n − 1].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build the LPS array of s and return the prefix of length lps[n − 1].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1, len = 0; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        return s.substring(0, lps[n - 1]);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Comparing every prefix with every suffix — O(n²) and too slow for n = 10^5.

---

⬅️ [Previous: Repeated String Match](./003-repeated-string-match.md) · [📋 String Pattern Matching list](./README.md) · [Next: Shortest Palindrome](./005-shortest-palindrome.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
