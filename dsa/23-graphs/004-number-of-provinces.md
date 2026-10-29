# 4. Number of Provinces

**LeetCode 547** · 🟡 Medium · Pattern: **Connected components (adjacency matrix)**
🔗 Solve it here: [https://leetcode.com/problems/number-of-provinces/](https://leetcode.com/problems/number-of-provinces/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/004-number-of-provinces.html](https://amitxaidev.github.io/dsa/23-graphs/004-number-of-provinces.html)

## The problem, in short

isConnected[i][j] = 1 means cities i and j are directly connected. A province is a group of connected cities. Count provinces.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The input is an adjacency matrix.

</details>

<details>
<summary>💡 Hint 2</summary>

Count how many times you have to start a new DFS.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each unvisited city, increment the count and DFS through row i of the matrix to mark its whole component.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, provinces = 0;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                provinces++;
                dfs(isConnected, i, seen);
            }
        }
        return provinces;
    }

    private void dfs(int[][] g, int u, boolean[] seen) {
        seen[u] = true;
        for (int v = 0; v < g.length; v++) {
            if (g[u][v] == 1 && !seen[v]) dfs(g, v, seen);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(n).

## Common mistake

⚠️ Treating the matrix as a grid and running "islands" over its cells — the cells are edges, not nodes.

---

⬅️ [Previous: Number of Islands](./003-number-of-islands.md) · [📋 Graphs list](./README.md) · [Next: Max Area of Island](./005-max-area-of-island.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
