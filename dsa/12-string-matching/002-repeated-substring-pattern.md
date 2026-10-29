# 2. Repeated Substring Pattern

**LeetCode 459** · 🟢 Easy · Pattern: **Doubling trick / LPS**
🔗 Solve it here: [https://leetcode.com/problems/repeated-substring-pattern/](https://leetcode.com/problems/repeated-substring-pattern/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/002-repeated-substring-pattern.html](https://amitxaidev.github.io/dsa/12-string-matching/002-repeated-substring-pattern.html)

## The problem, in short

Decide whether s can be built by repeating one of its substrings two or more times.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If s is a repetition, then s appears inside (s + s) with its first and last character removed.

</details>

<details>
<summary>💡 Hint 2</summary>

With KMP: let L = lps[n − 1]. s repeats exactly when L > 0 and n is divisible by n − L.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Compute the LPS array. The smallest repeating block has length n − lps[n − 1]; check that it's shorter than n and divides n.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1, len = 0; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        int border = lps[n - 1];
        return border > 0 && n % (n - border) == 0;   // block length = n - border
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Using (s + s).contains(s) without trimming the ends — it's always true.

---

⬅️ [Previous: Find the Index of the First Occurrence in a String](./001-find-the-index-of-the-first-occurrence-in-a-string.md) · [📋 String Pattern Matching list](./README.md) · [Next: Repeated String Match](./003-repeated-string-match.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
