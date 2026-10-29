# 5. Max Area of Island

**LeetCode 695** · 🟡 Medium · Pattern: **DFS returning size**
🔗 Solve it here: [https://leetcode.com/problems/max-area-of-island/](https://leetcode.com/problems/max-area-of-island/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/005-max-area-of-island.html](https://amitxaidev.github.io/dsa/23-graphs/005-max-area-of-island.html)

## The problem, in short

In a 0/1 grid, return the area (number of cells) of the largest island, or 0.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Same as Number of Islands, but DFS returns how many cells it sank.

</details>

<details>
<summary>💡 Hint 2</summary>

Area = 1 + areas of the four directions.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each land cell, run the sinking DFS that returns the size, and keep the maximum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                best = Math.max(best, area(grid, r, c));
        return best;
    }

    private int area(int[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == 0) return 0;
        g[r][c] = 0;
        return 1 + area(g, r + 1, c) + area(g, r - 1, c) + area(g, r, c + 1) + area(g, r, c - 1);
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(m·n).

## Common mistake

⚠️ Not marking cells as visited before recursing, so cells are counted multiple times.

---

⬅️ [Previous: Number of Provinces](./004-number-of-provinces.md) · [📋 Graphs list](./README.md) · [Next: Rotting Oranges](./006-rotting-oranges.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
