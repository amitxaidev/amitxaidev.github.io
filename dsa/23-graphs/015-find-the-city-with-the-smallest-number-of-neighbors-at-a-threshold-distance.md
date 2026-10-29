# 15. Find the City With the Smallest Number of Neighbors at a Threshold Distance

**LeetCode 1334** · 🟡 Medium · Pattern: **Floyd-Warshall**

## The problem, in short

In a weighted undirected graph of n cities, count for each city how many others are within distanceThreshold. Return the city with the fewest such neighbours; on ties, the one with the greatest number.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/015-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance.html](https://amitxaidev.github.io/dsa/23-graphs/015-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance.html)

## Understanding

**Really asking:** which city can reach the fewest others within the distance limit?

**Why this works:** Floyd-Warshall gives all-pairs shortest paths by trying every city k as a middle stop.

**Example:** 4 cities, threshold 4
```text
reachable counts: 0→2, 1→3, 2→3, 3→2
tie between 0 and 3 → pick the larger, 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

You need shortest distances between all pairs, and n ≤ 100.

</details>

<details>
<summary>💡 Hint 2</summary>

Floyd-Warshall: for every middle city k, try i → k → j.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Initialise a distance matrix with edges (both directions), 0 on the diagonal, infinity elsewhere. Triple loop with k outermost. Then count reachable cities per row and pick the best, preferring later indexes on ties.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int INF = 1_000_000_000;
        int[][] d = new int[n][n];
        for (int[] row : d) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) d[i][i] = 0;
        for (int[] e : edges) {
            d[e[0]][e[1]] = Math.min(d[e[0]][e[1]], e[2]);
            d[e[1]][e[0]] = Math.min(d[e[1]][e[0]], e[2]);
        }
        for (int k = 0; k < n; k++)              // k outermost
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
        int best = -1, fewest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) if (i != j && d[i][j] <= distanceThreshold) count++;
            if (count <= fewest) {               // <= keeps the larger index on ties
                fewest = count;
                best = i;
            }
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n³).
- **Space:** O(n²).

## Common mistake

⚠️ Putting k in an inner loop — k must be the outermost loop for Floyd-Warshall to be correct.

---

⬅️ [Previous: Cheapest Flights Within K Stops](./014-cheapest-flights-within-k-stops.md) · [📋 Graphs list](./README.md) · [Next: Min Cost to Connect All Points](./016-min-cost-to-connect-all-points.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
