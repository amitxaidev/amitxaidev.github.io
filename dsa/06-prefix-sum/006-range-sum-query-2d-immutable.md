# 6. Range Sum Query 2D - Immutable

**LeetCode 304** · 🟡 Medium · Pattern: **2D prefix sum**

## The problem, in short

Answer many queries for the sum of a rectangle inside a fixed matrix.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/range-sum-query-2d-immutable/](https://leetcode.com/problems/range-sum-query-2d-immutable/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/006-range-sum-query-2d-immutable.html](https://amitxaidev.github.io/dsa/06-prefix-sum/006-range-sum-query-2d-immutable.html)

## Understanding

**Really asking:** sum of any rectangle in a fixed grid, fast.

**Why this works:** P[r][c] holds the sum of everything above and to the left. A rectangle is the big corner sum minus the strip above and the strip to the left, plus the corner that got subtracted twice.

**Example:** rectangle rows 1..2, cols 1..2
```text
answer = P[3][3] - P[1][3] - P[3][1] + P[1][1]
(whole) - (top strip) - (left strip) + (top-left corner)
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Let P[r][c] be the sum of the rectangle from (0,0) to (r-1, c-1). Use an extra row and column of zeros.

</details>

<details>
<summary>💡 Hint 2</summary>

Build: P[r+1][c+1] = matrix[r][c] + P[r][c+1] + P[r+1][c] - P[r][c].

</details>

<details>
<summary>💡 Hint 3</summary>

Query uses inclusion–exclusion with four corners.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Precompute the padded 2D prefix array. The rectangle (r1,c1)–(r2,c2) equals P[r2+1][c2+1] - P[r1][c2+1] - P[r2+1][c1] + P[r1][c1]; the last term is added back because it was subtracted twice.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class NumMatrix {
    private final int[][] p;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        p = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                p[r + 1][c + 1] = matrix[r][c] + p[r][c + 1] + p[r + 1][c] - p[r][c];
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return p[r2 + 1][c2 + 1] - p[r1][c2 + 1] - p[r2 + 1][c1] + p[r1][c1];
    }
}
```

</details>

## Complexity

- **Time:** O(m·n) build, O(1) per query.
- **Space:** O(m·n).

## Common mistake

⚠️ Forgetting to add back the top-left corner, which was subtracted twice.

---

⬅️ [Previous: Product of Array Except Self](./005-product-of-array-except-self.md) · [📋 Prefix Sum list](./README.md) · [Next: Subarray Sum Equals K](./007-subarray-sum-equals-k.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
