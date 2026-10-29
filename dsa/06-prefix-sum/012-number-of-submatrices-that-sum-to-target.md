# 12. Number of Submatrices That Sum to Target

**LeetCode 1074** · 🔴 Hard · Pattern: **2D → 1D prefix + HashMap**

## The problem, in short

Count all non-empty rectangles in a matrix whose elements sum to a target.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/](https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/012-number-of-submatrices-that-sum-to-target.html](https://amitxaidev.github.io/dsa/06-prefix-sum/012-number-of-submatrices-that-sum-to-target.html)

## Understanding

**Really asking:** count rectangles in a grid with a given sum.

**Why this works:** fix a top row and a bottom row; squash the columns between them into one array of column sums. Now it's "subarray sum equals k" on that array.

**Example:** rows 0..1 of [[0,1],[1,0]] squashed → column sums [1, 1]
```text
subarrays summing to 1: [1], [1] → 2
repeat for every pair of rows and add up
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Fix a top row and a bottom row. The columns between them collapse into a 1D array of column sums.

</details>

<details>
<summary>💡 Hint 2</summary>

On that 1D array, count subarrays summing to target — exactly "Subarray Sum Equals K".

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Precompute prefix sums down each column. For every pair of rows (top, bottom), build the column sums in O(n) and run the prefix-sum + HashMap count. Total O(m² · n).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] col = new int[m + 1][n];             // col[r][c] = sum of rows 0..r-1 in column c
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++) col[r + 1][c] = col[r][c] + matrix[r][c];
        int ans = 0;
        for (int top = 0; top < m; top++) {
            for (int bot = top + 1; bot <= m; bot++) {
                Map<Integer, Integer> count = new HashMap<>();
                count.put(0, 1);
                int sum = 0;
                for (int c = 0; c < n; c++) {
                    sum += col[bot][c] - col[top][c];   // column c between the two rows
                    ans += count.getOrDefault(sum - target, 0);
                    count.merge(sum, 1, Integer::sum);
                }
            }
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(m² · n).
- **Space:** O(n).

## Common mistake

⚠️ Enumerating all four corners directly — O(m² n²) and too slow.

---

⬅️ [Previous: Corporate Flight Bookings](./011-corporate-flight-bookings.md) · [📋 Prefix Sum list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
