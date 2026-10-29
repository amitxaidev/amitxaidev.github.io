# 16. Min Cost to Connect All Points

**LeetCode 1584** · 🟡 Medium · Pattern: **Prim's MST (dense graph)**
🔗 Solve it here: [https://leetcode.com/problems/min-cost-to-connect-all-points/](https://leetcode.com/problems/min-cost-to-connect-all-points/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/016-min-cost-to-connect-all-points.html](https://amitxaidev.github.io/dsa/23-graphs/016-min-cost-to-connect-all-points.html)

## The problem, in short

Connect all points on a plane so that every point can reach every other, where an edge costs the Manhattan distance between its points. Return the minimum total cost.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

This is a minimum spanning tree on a complete graph.

</details>

<details>
<summary>💡 Hint 2</summary>

With n² edges, Prim's O(n²) version (no heap) is the simplest fast choice.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep minDist[i] = cheapest edge from the tree to point i. Repeat n times: pick the closest point not yet in the tree, add its cost, and update minDist of the others using it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, total = 0;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] inTree = new boolean[n];
        minDist[0] = 0;
        for (int step = 0; step < n; step++) {
            int u = -1;
            for (int i = 0; i < n; i++)
                if (!inTree[i] && (u == -1 || minDist[i] < minDist[u])) u = i;   // closest outside point
            inTree[u] = true;
            total += minDist[u];
            for (int v = 0; v < n; v++) {
                if (inTree[v]) continue;
                int d = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                if (d < minDist[v]) minDist[v] = d;
            }
        }
        return total;
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(n).

## Common mistake

⚠️ Building all n² edges and sorting them for Kruskal — works but uses much more memory.

---

⬅️ [Previous: Find the City With the Smallest Number of Neighbors at a Threshold Distance](./015-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance.md) · [📋 Graphs list](./README.md) · [Next: Redundant Connection](./017-redundant-connection.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
