# 1. Find the Index of the First Occurrence in a String

**LeetCode 28** · 🟢 Easy · Pattern: **KMP**

## The problem, in short

Return the index where needle first appears in haystack, or -1 if it doesn't appear.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/001-find-the-index-of-the-first-occurrence-in-a-string.html](https://amitxaidev.github.io/dsa/12-string-matching/001-find-the-index-of-the-first-occurrence-in-a-string.html)

## Understanding

**Really asking:** where does needle first appear in haystack?

**Why this works:** KMP's LPS table remembers how much of the needle still matches after a mismatch, so the haystack pointer never goes back.

**Example:** needle "abab" → lps [0, 0, 1, 2]
```text
text "abaabab": match "aba", mismatch at 'a' vs 'b'
jump j to lps[2] = 1 (keep "a") instead of restarting
continue → match found at index 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The brute force tries every start: O(n·m). Fine here, but learn KMP on it.

</details>

<details>
<summary>💡 Hint 2</summary>

KMP's LPS array: lps[i] = length of the longest proper prefix of needle[0..i] that is also a suffix.

</details>

<details>
<summary>💡 Hint 3</summary>

On a mismatch, jump j back to lps[j - 1] instead of restarting.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build the LPS table for the needle, then scan the haystack once. The haystack index never moves backwards, so the scan is linear.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m; ) {
            if (needle.charAt(i) == needle.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];   // fall back, don't advance i
            else lps[i++] = 0;
        }
        for (int i = 0, j = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m) return i - m;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(m).

## Common mistake

⚠️ Resetting j to 0 on every mismatch — that's the brute force, and it misses overlapping matches like "aab" in "aaab".

---

[📋 String Pattern Matching list](./README.md) · [Next: Repeated Substring Pattern](./002-repeated-substring-pattern.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
