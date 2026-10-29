# 7. Pacific Atlantic Water Flow

**LeetCode 417** · 🟡 Medium · Pattern: **Reverse BFS/DFS from the oceans**
🔗 Solve it here: [https://leetcode.com/problems/pacific-atlantic-water-flow/](https://leetcode.com/problems/pacific-atlantic-water-flow/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/007-pacific-atlantic-water-flow.html](https://amitxaidev.github.io/dsa/23-graphs/007-pacific-atlantic-water-flow.html)

## The problem, in short

Rain flows from a cell to neighbours with equal or lower height. The Pacific touches the top and left edges, the Atlantic the bottom and right. Return cells from which water can reach both oceans.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Checking every cell separately is slow. Flip it: start from each ocean and climb uphill.

</details>

<details>
<summary>💡 Hint 2</summary>

A cell reachable "uphill" from the Pacific edge can drain into the Pacific.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

DFS from all Pacific edge cells moving to neighbours with height >= current; same for the Atlantic. Cells marked by both are the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private int m, n;
    private int[][] h;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        h = heights;
        m = h.length;
        n = h[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            climb(r, 0, pac);
            climb(r, n - 1, atl);
        }
        for (int c = 0; c < n; c++) {
            climb(0, c, pac);
            climb(m - 1, c, atl);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
        return res;
    }

    private void climb(int r, int c, boolean[][] seen) {
        if (seen[r][c]) return;
        seen[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && h[nr][nc] >= h[r][c]) climb(nr, nc, seen);   // uphill only
        }
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(m·n).

## Common mistake

⚠️ Using &lt; instead of >= when climbing — equal heights also let water flow.

---

⬅️ [Previous: Rotting Oranges](./006-rotting-oranges.md) · [📋 Graphs list](./README.md) · [Next: Clone Graph](./008-clone-graph.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
