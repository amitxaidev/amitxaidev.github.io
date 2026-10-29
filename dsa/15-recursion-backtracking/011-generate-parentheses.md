# 11. Generate Parentheses

**LeetCode 22** · 🟡 Medium · Pattern: **Backtracking with counts**
🔗 Solve it here: [https://leetcode.com/problems/generate-parentheses/](https://leetcode.com/problems/generate-parentheses/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/011-generate-parentheses.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/011-generate-parentheses.html)

## The problem, in short

Return every valid string of n pairs of parentheses.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You may add '(' while you've used fewer than n.

</details>

<details>
<summary>💡 Hint 2</summary>

You may add ')' only while closes &lt; opens.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Recurse with counts of open and close brackets used. These two rules generate only valid strings, so no checking is needed at the end.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void build(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            build(n, open + 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {                    // only close what is open
            sb.append(')');
            build(n, open, close + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(4^n / √n) — the Catalan number of results.
- **Space:** O(n).

## Common mistake

⚠️ Generating all 2^(2n) strings and filtering valid ones.

---

⬅️ [Previous: Letter Combinations of a Phone Number](./010-letter-combinations-of-a-phone-number.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Palindrome Partitioning](./012-palindrome-partitioning.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
