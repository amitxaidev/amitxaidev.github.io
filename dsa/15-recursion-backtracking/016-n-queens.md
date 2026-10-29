# 16. N-Queens

**LeetCode 51** · 🔴 Hard · Pattern: **Backtracking row by row**
🔗 Solve it here: [https://leetcode.com/problems/n-queens/](https://leetcode.com/problems/n-queens/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/016-n-queens.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/016-n-queens.html)

## The problem, in short

Place n queens on an n×n board so that no two attack each other (same row, column or diagonal). Return all such boards.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Place exactly one queen per row; recurse row by row.

</details>

<details>
<summary>💡 Hint 2</summary>

Track used columns and both diagonals: r − c (one direction) and r + c (the other).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

At row r, try each column c that's free in cols, diag1[r − c + n − 1] and diag2[r + c]. Mark, recurse to r + 1, unmark. When r == n, convert the queen positions to strings.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solve(0, n, new int[n], new boolean[n], new boolean[2 * n], new boolean[2 * n], res);
        return res;
    }

    private void solve(int r, int n, int[] queenCol, boolean[] cols, boolean[] d1, boolean[] d2,
                       List<List<String>> res) {
        if (r == n) {
            List<String> board = new ArrayList<>();
            for (int c : queenCol) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            res.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (cols[c] || d1[r - c + n] || d2[r + c]) continue;   // attacked
            cols[c] = d1[r - c + n] = d2[r + c] = true;
            queenCol[r] = c;
            solve(r + 1, n, queenCol, cols, d1, d2, res);
            cols[c] = d1[r - c + n] = d2[r + c] = false;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n!).
- **Space:** O(n).

## Common mistake

⚠️ Checking attacks by scanning the whole board each time — O(n) per check. The three boolean arrays make it O(1).

---

⬅️ [Previous: Path with Maximum Gold](./015-path-with-maximum-gold.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Sudoku Solver](./017-sudoku-solver.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
