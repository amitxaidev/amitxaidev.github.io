# 11. Is Graph Bipartite?

**LeetCode 785** · 🟡 Medium · Pattern: **2-colouring with BFS**

## The problem, in short

Decide whether an undirected graph's nodes can be split into two groups so that every edge connects nodes from different groups.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/is-graph-bipartite/](https://leetcode.com/problems/is-graph-bipartite/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/011-is-graph-bipartite.html](https://amitxaidev.github.io/dsa/23-graphs/011-is-graph-bipartite.html)

## Understanding

**Really asking:** can nodes be split into two teams with every edge between teams?

**Why this works:** colour with two colours using BFS; a neighbour with your own colour means it's impossible.

**Example:** square 0-1-2-3-0
```text
0 red, 1 blue, 2 red, 3 blue → no conflict → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Try to colour nodes with two colours so neighbours always differ.

</details>

<details>
<summary>💡 Hint 2</summary>

The graph may be disconnected — start a BFS from every uncoloured node.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

color[] = 0 (none), 1 or −1. BFS: colour the start 1; give each uncoloured neighbour the opposite colour; if a neighbour already has the same colour, it's not bipartite.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int s = 0; s < n; s++) {
            if (color[s] != 0) continue;
            color[s] = 1;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(s);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (color[v] == color[u]) return false;   // same side: conflict
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        q.offer(v);
                    }
                }
            }
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(V + E).
- **Space:** O(V).

## Common mistake

⚠️ Only starting from node 0 and missing other components.

---

⬅️ [Previous: Course Schedule II](./010-course-schedule-ii.md) · [📋 Graphs list](./README.md) · [Next: Network Delay Time](./012-network-delay-time.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
