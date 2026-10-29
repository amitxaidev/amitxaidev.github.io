# 12. Palindromic Substrings

**LeetCode 647** · 🟡 Medium · Pattern: **Expand around centre**
🔗 Solve it here: [https://leetcode.com/problems/palindromic-substrings/](https://leetcode.com/problems/palindromic-substrings/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/012-palindromic-substrings.html](https://amitxaidev.github.io/dsa/11-strings/012-palindromic-substrings.html)

## The problem, in short

Count how many substrings (by position) are palindromes.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Same centres as Longest Palindromic Substring.

</details>

<details>
<summary>💡 Hint 2</summary>

Every successful expansion step is one more palindrome.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each of the 2n − 1 centres, expand while the ends match, adding one to the count each time.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int c = 0; c < 2 * s.length() - 1; c++) {
            int l = c / 2, r = l + c % 2;   // even c: char centre, odd c: gap centre
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(1).

## Common mistake

⚠️ Generating every substring and checking it — O(n³).

---

⬅️ [Previous: String to Integer (atoi)](./011-string-to-integer-atoi.md) · [📋 Strings list](./README.md) · [Next: Sort Characters By Frequency](./013-sort-characters-by-frequency.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
