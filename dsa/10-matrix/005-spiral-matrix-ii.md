# 5. Spiral Matrix II

**LeetCode 59** · 🟡 Medium · Pattern: **Shrinking boundaries**
🔗 Solve it here: [https://leetcode.com/problems/spiral-matrix-ii/](https://leetcode.com/problems/spiral-matrix-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/005-spiral-matrix-ii.html](https://amitxaidev.github.io/dsa/10-matrix/005-spiral-matrix-ii.html)

## The problem, in short

Build an n × n matrix filled with 1 to n² in clockwise spiral order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Same four boundaries as Spiral Matrix, but write instead of read.

</details>

<details>
<summary>💡 Hint 2</summary>

A counter tells you which number to write next.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill the top row, right column, bottom row and left column, shrinking the boundaries each time, until the counter passes n².

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, k = 1;
        while (k <= n * n) {
            for (int c = left; c <= right; c++) m[top][c] = k++;
            top++;
            for (int r = top; r <= bottom; r++) m[r][right] = k++;
            right--;
            for (int c = right; c >= left; c--) m[bottom][c] = k++;
            bottom--;
            for (int r = bottom; r >= top; r--) m[r][left] = k++;
            left++;
        }
        return m;
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(1) besides the output.

## Common mistake

⚠️ Off-by-one on the boundaries leading to overwriting cells already filled.

---

⬅️ [Previous: Spiral Matrix](./004-spiral-matrix.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Set Matrix Zeroes](./006-set-matrix-zeroes.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
