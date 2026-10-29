# 7. Minimum Path Sum

**LeetCode 64** · 🟡 Medium · Pattern: **2D grid DP**
🔗 Solve it here: [https://leetcode.com/problems/minimum-path-sum/](https://leetcode.com/problems/minimum-path-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/007-minimum-path-sum.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/007-minimum-path-sum.html)

## The problem, in short

Move only right or down from the top-left to the bottom-right of a grid of non-negative numbers. Minimise the sum of the numbers on the path.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Best cost to reach a cell = its value + min(best from above, best from left).

</details>

<details>
<summary>💡 Hint 2</summary>

The first row and column can only be reached one way.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill the grid in place (or a 1D array) using the transition above.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue;
                int up = r > 0 ? grid[r - 1][c] : Integer.MAX_VALUE;
                int left = c > 0 ? grid[r][c - 1] : Integer.MAX_VALUE;
                grid[r][c] += Math.min(up, left);
            }
        }
        return grid[m - 1][n - 1];
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(1) when updating the grid in place.

## Common mistake

⚠️ Using a greedy "go to the cheaper neighbour" walk — it can miss the best path.

---

⬅️ [Previous: Unique Paths](./006-unique-paths.md) · [📋 Dynamic Programming list](./README.md) · [Next: Triangle](./008-triangle.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
