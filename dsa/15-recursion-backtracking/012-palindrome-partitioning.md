# 12. Palindrome Partitioning

**LeetCode 131** · 🟡 Medium · Pattern: **Backtracking on cut positions**
🔗 Solve it here: [https://leetcode.com/problems/palindrome-partitioning/](https://leetcode.com/problems/palindrome-partitioning/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/012-palindrome-partitioning.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/012-palindrome-partitioning.html)

## The problem, in short

Split a string into pieces so that every piece is a palindrome. Return all such splits.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Choose where the first piece ends; it must be a palindrome.

</details>

<details>
<summary>💡 Hint 2</summary>

Then solve the same problem for the rest of the string.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

backtrack(start): for each end from start to n − 1, if s[start..end] is a palindrome, add it and recurse from end + 1. Record the path when start reaches n.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (!isPal(s, start, end)) continue;
            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n · 2^n).
- **Space:** O(n).

## Common mistake

⚠️ Calling substring before checking the palindrome — check with indexes first to avoid making useless strings.

---

⬅️ [Previous: Generate Parentheses](./011-generate-parentheses.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Word Search](./013-word-search.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
