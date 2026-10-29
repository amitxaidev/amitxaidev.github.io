# 8. Search a 2D Matrix II

**LeetCode 240** · 🟡 Medium · Pattern: **Staircase search**
🔗 Solve it here: [https://leetcode.com/problems/search-a-2d-matrix-ii/](https://leetcode.com/problems/search-a-2d-matrix-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/008-search-a-2d-matrix-ii.html](https://amitxaidev.github.io/dsa/10-matrix/008-search-a-2d-matrix-ii.html)

## The problem, in short

Rows are sorted left to right and columns top to bottom (but rows don't continue each other). Decide if target is present.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Start at the top-right corner.

</details>

<details>
<summary>💡 Hint 2</summary>

From there, one direction only increases and the other only decreases.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

At (r, c): if the value is bigger than target, the whole column below is bigger too, so move left. If smaller, the whole row to the left is smaller, so move down. Each step removes a row or a column.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            int v = matrix[r][c];
            if (v == target) return true;
            if (v > target) c--;   // drop this column
            else r++;              // drop this row
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(m + n).
- **Space:** O(1).

## Common mistake

⚠️ Starting at the top-left, where both directions increase and you can't decide where to go.

---

⬅️ [Previous: Search a 2D Matrix](./007-search-a-2d-matrix.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Valid Sudoku](./009-valid-sudoku.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
