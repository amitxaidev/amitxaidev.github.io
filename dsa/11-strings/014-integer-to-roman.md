# 14. Integer to Roman

**LeetCode 12** · 🟡 Medium · Pattern: **Greedy table**
🔗 Solve it here: [https://leetcode.com/problems/integer-to-roman/](https://leetcode.com/problems/integer-to-roman/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/014-integer-to-roman.html](https://amitxaidev.github.io/dsa/11-strings/014-integer-to-roman.html)

## The problem, in short

Convert an integer from 1 to 3999 into a Roman numeral.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Put the subtractive forms (CM, CD, XC, XL, IX, IV) into the value table too.

</details>

<details>
<summary>💡 Hint 2</summary>

Greedily take the largest value that still fits.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Arrays of 13 values and symbols in descending order. For each, while num >= value, append the symbol and subtract.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String intToRoman(int num) {
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] syms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {   // take the biggest piece that fits
                sb.append(syms[i]);
                num -= vals[i];
            }
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(1) — the output is at most 15 characters.
- **Space:** O(1).

## Common mistake

⚠️ Leaving out the subtractive pairs, which produces IIII instead of IV.

---

⬅️ [Previous: Sort Characters By Frequency](./013-sort-characters-by-frequency.md) · [📋 Strings list](./README.md) · [Next: String Compression](./015-string-compression.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
