# 4. Spiral Matrix

**LeetCode 54** · 🟡 Medium · Pattern: **Shrinking boundaries**
🔗 Solve it here: [https://leetcode.com/problems/spiral-matrix/](https://leetcode.com/problems/spiral-matrix/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/004-spiral-matrix.html](https://amitxaidev.github.io/dsa/10-matrix/004-spiral-matrix.html)

## The problem, in short

Return all elements of an m × n matrix in clockwise spiral order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep four boundaries: top, bottom, left, right.

</details>

<details>
<summary>💡 Hint 2</summary>

Walk right, down, left, up, shrinking the matching boundary after each side.

</details>

<details>
<summary>💡 Hint 3</summary>

Check the boundaries again before walking left and up — a single row or column remains in the middle.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Loop while top &lt;= bottom and left &lt;= right: top row, right column, bottom row (if top &lt;= bottom), left column (if left &lt;= right).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) res.add(matrix[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) res.add(matrix[r][right]);
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) res.add(matrix[bottom][c]);
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) res.add(matrix[r][left]);
                left++;
            }
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(1) besides the output.

## Common mistake

⚠️ Not re-checking boundaries before the bottom row and left column, which prints the middle row or column twice.

---

⬅️ [Previous: Rotate Image](./003-rotate-image.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Spiral Matrix II](./005-spiral-matrix-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
