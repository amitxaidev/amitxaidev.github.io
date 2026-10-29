# 2. Transpose Matrix

**LeetCode 867** · 🟢 Easy · Pattern: **Index swap**
🔗 Solve it here: [https://leetcode.com/problems/transpose-matrix/](https://leetcode.com/problems/transpose-matrix/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/002-transpose-matrix.html](https://amitxaidev.github.io/dsa/10-matrix/002-transpose-matrix.html)

## The problem, in short

Return the transpose of a matrix (rows become columns). The matrix may not be square.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The result has dimensions n × m.

</details>

<details>
<summary>💡 Hint 2</summary>

res[c][r] = matrix[r][c].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Allocate the flipped-size array and copy every cell with swapped indexes.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                res[c][r] = matrix[r][c];
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(m·n) for the output.

## Common mistake

⚠️ Swapping in place — impossible for non-square matrices.

---

⬅️ [Previous: Matrix Diagonal Sum](./001-matrix-diagonal-sum.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Rotate Image](./003-rotate-image.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
