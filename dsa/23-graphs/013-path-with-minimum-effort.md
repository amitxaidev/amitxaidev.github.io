# 13. Path With Minimum Effort

**LeetCode 1631** · 🟡 Medium · Pattern: **Dijkstra on a grid (minimax)**
🔗 Solve it here: [https://leetcode.com/problems/path-with-minimum-effort/](https://leetcode.com/problems/path-with-minimum-effort/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/013-path-with-minimum-effort.html](https://amitxaidev.github.io/dsa/23-graphs/013-path-with-minimum-effort.html)

## The problem, in short

Walk from the top-left to the bottom-right of a height grid. A path's effort is its largest height difference between consecutive cells. Return the minimum effort.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

This is a shortest-path problem where a path's "length" is its maximum step, not its sum.

</details>

<details>
<summary>💡 Hint 2</summary>

Dijkstra still works: the new cost is max(current cost, |height difference|).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

effort[][] = infinity, start at 0. Min-heap of (effort, r, c). Relax each neighbour with max(e, diff). The first time the target is popped, its effort is final.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));   // {effort, r, c}
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int e = cur[0], r = cur[1], c = cur[2];
            if (r == m - 1 && c == n - 1) return e;
            if (e > effort[r][c]) continue;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int ne = Math.max(e, Math.abs(heights[nr][nc] - heights[r][c]));   // max, not sum
                if (ne < effort[nr][nc]) {
                    effort[nr][nc] = ne;
                    pq.offer(new int[]{ne, nr, nc});
                }
            }
        }
        return 0;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n log(m·n)).
- **Space:** O(m·n).

## Common mistake

⚠️ Summing the differences like a normal shortest path.

---

⬅️ [Previous: Network Delay Time](./012-network-delay-time.md) · [📋 Graphs list](./README.md) · [Next: Cheapest Flights Within K Stops](./014-cheapest-flights-within-k-stops.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
