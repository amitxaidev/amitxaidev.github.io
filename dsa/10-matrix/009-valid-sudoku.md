# 9. Valid Sudoku

**LeetCode 36** · 🟡 Medium · Pattern: **Row/column/box sets**

## The problem, in short

Check whether a partially filled 9×9 Sudoku board breaks any rule: no digit repeats in a row, a column or a 3×3 box. The puzzle doesn't need to be solvable.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/valid-sudoku/](https://leetcode.com/problems/valid-sudoku/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/009-valid-sudoku.html](https://amitxaidev.github.io/dsa/10-matrix/009-valid-sudoku.html)

## Understanding

**Really asking:** does any row, column or 3×3 box repeat a digit?

**Why this works:** remember which digits each row, column and box has seen. Box number = (r/3)·3 + c/3.

**Example:** a '5' at (0,0) and another '5' at (1,1)
```text
both in box 0 → repeat → false
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep a "seen" record for each row, column and box.

</details>

<details>
<summary>💡 Hint 2</summary>

The box index of cell (r, c) is (r / 3) * 3 + c / 3.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Use three 9×9 boolean arrays. For each filled cell, if the digit was already seen in its row, column or box, return false; otherwise mark it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], boxes = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int d = board[r][c] - '1';
                int b = (r / 3) * 3 + c / 3;
                if (rows[r][d] || cols[c][d] || boxes[b][d]) return false;
                rows[r][d] = cols[c][d] = boxes[b][d] = true;
            }
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(81) = O(1).
- **Space:** O(1).

## Common mistake

⚠️ Computing the box index as r / 3 + c / 3, which maps different boxes to the same index.

---

⬅️ [Previous: Search a 2D Matrix II](./008-search-a-2d-matrix-ii.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Game of Life](./010-game-of-life.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
