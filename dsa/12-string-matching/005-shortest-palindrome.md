# 5. Shortest Palindrome

**LeetCode 214** · 🔴 Hard · Pattern: **KMP on s + # + reverse**

## The problem, in short

Add characters only to the front of s to make it a palindrome. Return the shortest such palindrome.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/shortest-palindrome/](https://leetcode.com/problems/shortest-palindrome/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/005-shortest-palindrome.html](https://amitxaidev.github.io/dsa/12-string-matching/005-shortest-palindrome.html)

## Understanding

**Really asking:** add the fewest letters in front to make a palindrome.

**Why this works:** find the longest palindromic prefix: run KMP on s + "#" + reverse(s). Whatever comes after it must be mirrored in front.

**Example:** "aacecaaa"
```text
longest palindromic prefix "aacecaa" (7)
leftover "a" → put "a" in front → "aaacecaaa"
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Find the longest prefix of s that is already a palindrome.

</details>

<details>
<summary>💡 Hint 2</summary>

That prefix equals a suffix of reverse(s). Build t = s + "#" + reverse(s) and compute LPS.

</details>

<details>
<summary>💡 Hint 3</summary>

The '#' stops the match from running past the middle.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

lps of t's last position = length L of the longest palindromic prefix. Prepend reverse of s[L..] to s.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String t = s + "#" + rev;
        int[] lps = new int[t.length()];
        for (int i = 1, len = 0; i < t.length(); ) {
            if (t.charAt(i) == t.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        int keep = lps[t.length() - 1];   // longest palindromic prefix
        return rev.substring(0, s.length() - keep) + s;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Leaving out the separator, so the LPS can be longer than s itself.

---

⬅️ [Previous: Longest Happy Prefix](./004-longest-happy-prefix.md) · [📋 String Pattern Matching list](./README.md) · [Next: Longest Duplicate Substring](./006-longest-duplicate-substring.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
