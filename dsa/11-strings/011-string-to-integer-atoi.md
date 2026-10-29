# 11. String to Integer (atoi)

**LeetCode 8** · 🟡 Medium · Pattern: **Parsing with overflow clamp**
🔗 Solve it here: [https://leetcode.com/problems/string-to-integer-atoi/](https://leetcode.com/problems/string-to-integer-atoi/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/011-string-to-integer-atoi.html](https://amitxaidev.github.io/dsa/11-strings/011-string-to-integer-atoi.html)

## The problem, in short

Parse an integer from a string: skip leading spaces, read an optional sign, read digits until a non-digit, and clamp the result to the 32-bit range.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Handle the steps in order: spaces, sign, digits.

</details>

<details>
<summary>💡 Hint 2</summary>

Before adding a digit, check if result would pass Integer.MAX_VALUE.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk with an index. After spaces and sign, for each digit check result > (MAX - d) / 10; if so, return the clamped limit for the sign. Otherwise result = result * 10 + d.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, result = 0;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - d) / 10) {   // next step would overflow
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + d;
            i++;
        }
        return sign * result;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using Integer.parseInt or a long without limit checks — very long digit strings still overflow a long.

---

⬅️ [Previous: Longest Palindromic Substring](./010-longest-palindromic-substring.md) · [📋 Strings list](./README.md) · [Next: Palindromic Substrings](./012-palindromic-substrings.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
