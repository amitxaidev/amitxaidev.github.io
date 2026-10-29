# 15. Path with Maximum Gold

**LeetCode 1219** · 🟡 Medium · Pattern: **Grid DFS backtracking**
🔗 Solve it here: [https://leetcode.com/problems/path-with-maximum-gold/](https://leetcode.com/problems/path-with-maximum-gold/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/015-path-with-maximum-gold.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/015-path-with-maximum-gold.html)

## The problem, in short

Each grid cell holds some gold (0 means you can't step there). Starting anywhere, walk up/down/left/right without revisiting a cell and collect gold. Return the most gold possible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Try every non-zero cell as a start.

</details>

<details>
<summary>💡 Hint 2</summary>

DFS with backtracking: take the gold, mark the cell 0, explore, then put the gold back.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each start, dfs returns the best total from that cell: its gold plus the best of the four neighbours. Restore the cell after exploring.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int getMaximumGold(int[][] grid) {
        int best = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] > 0) best = Math.max(best, dfs(grid, r, c));
        return best;
    }

    private int dfs(int[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == 0) return 0;
        int gold = g[r][c];
        g[r][c] = 0;                                        // mark visited
        int more = Math.max(Math.max(dfs(g, r + 1, c), dfs(g, r - 1, c)),
                            Math.max(dfs(g, r, c + 1), dfs(g, r, c - 1)));
        g[r][c] = gold;                                     // backtrack
        return gold + more;
    }
}
```

</details>

## Complexity

- **Time:** O(G · 3^G), G = gold cells (at most 25).
- **Space:** O(G).

## Common mistake

⚠️ Not restoring the cell's gold, which corrupts later starts.

---

⬅️ [Previous: Partition to K Equal Sum Subsets](./014-partition-to-k-equal-sum-subsets.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: N-Queens](./016-n-queens.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
