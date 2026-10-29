# 21. Swim in Rising Water

**LeetCode 778** · 🔴 Hard · Pattern: **Dijkstra (minimax) on a grid**

## The problem, in short

At time t the water level is t, and you can swim between adjacent cells whose heights are both at most t. Return the least time to get from the top-left to the bottom-right.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/swim-in-rising-water/](https://leetcode.com/problems/swim-in-rising-water/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/021-swim-in-rising-water.html](https://amitxaidev.github.io/dsa/23-graphs/021-swim-in-rising-water.html)

## Understanding

**Really asking:** the earliest time you can swim from the top-left to the bottom-right.

**Why this works:** the time for a path is its highest cell; minimise that with a min-heap Dijkstra.

**Example:** [[0,2],[1,3]]
```text
best path 0 → 1 → 3 → time 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The time needed for a path is the maximum height along it.

</details>

<details>
<summary>💡 Hint 2</summary>

Minimise that maximum — Dijkstra with max instead of sum, or Union-Find adding cells in height order.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Min-heap of (maxHeightSoFar, r, c) starting with grid[0][0]. Pop the smallest; when it's the target, return. Push unvisited neighbours with max(current, their height).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));   // {time, r, c}
        pq.offer(new int[]{grid[0][0], 0, 0});
        seen[0][0] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (true) {
            int[] cur = pq.poll();
            if (cur[1] == n - 1 && cur[2] == n - 1) return cur[0];
            for (int[] d : dirs) {
                int r = cur[1] + d[0], c = cur[2] + d[1];
                if (r < 0 || c < 0 || r >= n || c >= n || seen[r][c]) continue;
                seen[r][c] = true;
                pq.offer(new int[]{Math.max(cur[0], grid[r][c]), r, c});   // the path's highest cell
            }
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n² log n).
- **Space:** O(n²).

## Common mistake

⚠️ Using plain BFS by steps — the number of moves doesn't matter, only the highest cell on the path.

---

⬅️ [Previous: Critical Connections in a Network](./020-critical-connections-in-a-network.md) · [📋 Graphs list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
