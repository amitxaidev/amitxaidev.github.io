# 10. Letter Combinations of a Phone Number

**LeetCode 17** · 🟡 Medium · Pattern: **Backtracking over choices**
🔗 Solve it here: [https://leetcode.com/problems/letter-combinations-of-a-phone-number/](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/010-letter-combinations-of-a-phone-number.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/010-letter-combinations-of-a-phone-number.html)

## The problem, in short

Each digit 2–9 maps to letters as on a phone keypad. Return all letter strings the digit string could represent.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

One recursion level per digit.

</details>

<details>
<summary>💡 Hint 2</summary>

At each level loop over the letters of that digit.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a StringBuilder path. At index i, for every letter of digits[i], append, recurse to i + 1, and delete the last character. Return an empty list for empty input.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int i, StringBuilder path, List<String> res) {
        if (i == digits.length()) {
            res.add(path.toString());
            return;
        }
        for (char c : KEYS[digits.charAt(i) - '0'].toCharArray()) {
            path.append(c);
            backtrack(digits, i + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(4^n · n).
- **Space:** O(n).

## Common mistake

⚠️ Returning [""] for an empty input — the expected answer is an empty list.

---

⬅️ [Previous: Combination Sum II](./009-combination-sum-ii.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Generate Parentheses](./011-generate-parentheses.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
