# 6. Set Matrix Zeroes

**LeetCode 73** · 🟡 Medium · Pattern: **First row/column as markers**
🔗 Solve it here: [https://leetcode.com/problems/set-matrix-zeroes/](https://leetcode.com/problems/set-matrix-zeroes/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/006-set-matrix-zeroes.html](https://amitxaidev.github.io/dsa/10-matrix/006-set-matrix-zeroes.html)

## The problem, in short

If a cell is 0, set its whole row and column to 0. Do it in place, ideally with O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Using two boolean arrays (rows, cols) is the easy O(m + n) version.

</details>

<details>
<summary>💡 Hint 2</summary>

For O(1), use the first row and first column as those arrays.

</details>

<details>
<summary>💡 Hint 3</summary>

Remember separately whether the first row and first column themselves had a zero.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Record if row 0 / column 0 contain zeros. Mark matrix[r][0] and matrix[0][c] for every zero in the rest. Zero out inner cells using the marks, then handle row 0 and column 0 last.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, col0 = false;
        for (int c = 0; c < n; c++) if (matrix[0][c] == 0) row0 = true;
        for (int r = 0; r < m; r++) if (matrix[r][0] == 0) col0 = true;
        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                if (matrix[r][c] == 0) { matrix[r][0] = 0; matrix[0][c] = 0; }   // mark
        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                if (matrix[r][0] == 0 || matrix[0][c] == 0) matrix[r][c] = 0;
        if (row0) for (int c = 0; c < n; c++) matrix[0][c] = 0;
        if (col0) for (int r = 0; r < m; r++) matrix[r][0] = 0;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(1).

## Common mistake

⚠️ Zeroing cells while still scanning — new zeros then wipe out rows and columns they shouldn't.

---

⬅️ [Previous: Spiral Matrix II](./005-spiral-matrix-ii.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Search a 2D Matrix](./007-search-a-2d-matrix.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
