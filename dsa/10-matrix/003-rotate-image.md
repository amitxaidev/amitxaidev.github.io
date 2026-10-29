# 3. Rotate Image

**LeetCode 48** · 🟡 Medium · Pattern: **Transpose + reverse rows**

## The problem, in short

Rotate an n × n matrix 90 degrees clockwise, in place.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/rotate-image/](https://leetcode.com/problems/rotate-image/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/003-rotate-image.html](https://amitxaidev.github.io/dsa/10-matrix/003-rotate-image.html)

## Understanding

**Really asking:** turn the picture 90° clockwise without a second matrix.

**Why this works:** transpose (mirror across the diagonal), then reverse each row. Together that's a clockwise turn.

**Example:** [[1,2,3],[4,5,6],[7,8,9]]
```text
transpose → [[1,4,7],[2,5,8],[3,6,9]]
reverse rows → [[7,4,1],[8,5,2],[9,6,3]]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Transpose the matrix (swap across the main diagonal).

</details>

<details>
<summary>💡 Hint 2</summary>

Then reverse each row.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Transpose by swapping matrix[i][j] with matrix[j][i] for j > i, then reverse every row. Together these equal a clockwise rotation. (Reversing columns instead gives counter-clockwise.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {   // only above the diagonal
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int[] row : matrix) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int t = row[l];
                row[l] = row[r];
                row[r] = t;
            }
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(1).

## Common mistake

⚠️ Transposing with j starting at 0, which swaps every pair twice and undoes the work.

---

⬅️ [Previous: Transpose Matrix](./002-transpose-matrix.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Spiral Matrix](./004-spiral-matrix.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
