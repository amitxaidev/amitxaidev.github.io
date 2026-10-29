# 12. Valid Parenthesis String

**LeetCode 678** · 🟡 Medium · Pattern: **Range of open counts**
🔗 Solve it here: [https://leetcode.com/problems/valid-parenthesis-string/](https://leetcode.com/problems/valid-parenthesis-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/012-valid-parenthesis-string.html](https://amitxaidev.github.io/dsa/22-greedy/012-valid-parenthesis-string.html)

## The problem, in short

A string has '(', ')' and '*', where '*' can be '(', ')' or empty. Decide whether it can be a valid parentheses string.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track the possible range [lo, hi] of open brackets.

</details>

<details>
<summary>💡 Hint 2</summary>

'(' raises both, ')' lowers both, '*' lowers lo and raises hi.

</details>

<details>
<summary>💡 Hint 3</summary>

If hi drops below 0, fail. Keep lo at least 0.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass maintaining lo and hi. At the end, valid if lo == 0 (some choice closes everything).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;   // min and max possible open count
        for (char c : s.toCharArray()) {
            if (c == '(') { lo++; hi++; }
            else if (c == ')') { lo--; hi--; }
            else { lo--; hi++; }
            if (hi < 0) return false;   // too many ')' even at best
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Treating every '*' as one fixed choice — you need to keep all options open.

---

⬅️ [Previous: Partition Labels](./011-partition-labels.md) · [📋 Greedy list](./README.md) · [Next: Hand of Straights](./013-hand-of-straights.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
