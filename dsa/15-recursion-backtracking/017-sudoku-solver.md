# 17. Sudoku Solver

**LeetCode 37** · 🔴 Hard · Pattern: **Backtracking on empty cells**
🔗 Solve it here: [https://leetcode.com/problems/sudoku-solver/](https://leetcode.com/problems/sudoku-solver/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/017-sudoku-solver.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/017-sudoku-solver.html)

## The problem, in short

Fill the empty cells of a 9×9 Sudoku so every row, column and 3×3 box contains 1–9 exactly once. The puzzle has exactly one solution.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Find an empty cell, try digits 1–9 that don't break a rule, recurse.

</details>

<details>
<summary>💡 Hint 2</summary>

If no digit works, undo and return false so the caller tries its next digit.

</details>

<details>
<summary>💡 Hint 3</summary>

Keep row, column and box "used" arrays to test a digit in O(1).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Collect the used digits first. solve(pos) walks cells in order; for an empty cell try each allowed digit, mark, recurse; on failure unmark and reset the cell.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private final boolean[][] row = new boolean[9][10], col = new boolean[9][10], box = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (board[r][c] != '.') mark(r, c, board[r][c] - '0', true);
        solve(board, 0);
    }

    private boolean solve(char[][] b, int pos) {
        if (pos == 81) return true;
        int r = pos / 9, c = pos % 9;
        if (b[r][c] != '.') return solve(b, pos + 1);
        for (int d = 1; d <= 9; d++) {
            if (row[r][d] || col[c][d] || box[(r / 3) * 3 + c / 3][d]) continue;
            b[r][c] = (char) ('0' + d);
            mark(r, c, d, true);
            if (solve(b, pos + 1)) return true;
            mark(r, c, d, false);              // undo
            b[r][c] = '.';
        }
        return false;
    }

    private void mark(int r, int c, int d, boolean v) {
        row[r][d] = col[c][d] = box[(r / 3) * 3 + c / 3][d] = v;
    }
}
```

</details>

## Complexity

- **Time:** Exponential in the worst case, fast in practice with O(1) checks.
- **Space:** O(81).

## Common mistake

⚠️ Not resetting the cell to '.' after a failed try.

---

⬅️ [Previous: N-Queens](./016-n-queens.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Permutation Sequence](./018-permutation-sequence.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
