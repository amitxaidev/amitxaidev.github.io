# 13. Word Search

**LeetCode 79** · 🟡 Medium · Pattern: **Grid DFS backtracking**

## The problem, in short

Decide whether a word can be traced in a letter grid by moving up, down, left or right, without reusing a cell.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/word-search/](https://leetcode.com/problems/word-search/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/013-word-search.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/013-word-search.html)

## Understanding

**Really asking:** can you trace the word through neighbouring cells without reusing a cell?

**Why this works:** DFS from each matching start cell; mark cells on the current path and unmark them when you go back.

**Example:** word "SEE" on [[A,B,C,E],[S,F,C,S],[A,D,E,E]]
```text
start S at (1,3) → E at (2,3) → E at (2,2) ✓
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Start a DFS from every cell matching the first letter.

</details>

<details>
<summary>💡 Hint 2</summary>

Mark a cell as visited while it's on the current path, and unmark it on the way back.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dfs(r, c, i): fail if out of bounds or the letter doesn't match word[i]. If i is the last index, succeed. Temporarily replace the cell with '#', try four neighbours, then restore.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                if (dfs(board, word, r, c, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] b, String w, int r, int c, int i) {
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != w.charAt(i)) return false;
        if (i == w.length() - 1) return true;
        char saved = b[r][c];
        b[r][c] = '#';                                 // mark visited
        boolean found = dfs(b, w, r + 1, c, i + 1) || dfs(b, w, r - 1, c, i + 1)
                     || dfs(b, w, r, c + 1, i + 1) || dfs(b, w, r, c - 1, i + 1);
        b[r][c] = saved;                               // restore
        return found;
    }
}
```

</details>

## Complexity

- **Time:** O(m · n · 3^L), L = word length.
- **Space:** O(L) recursion.

## Common mistake

⚠️ Forgetting to restore the cell, which blocks other paths that need it.

---

⬅️ [Previous: Palindrome Partitioning](./012-palindrome-partitioning.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Partition to K Equal Sum Subsets](./014-partition-to-k-equal-sum-subsets.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
