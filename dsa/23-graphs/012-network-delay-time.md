# 12. Network Delay Time

**LeetCode 743** · 🟡 Medium · Pattern: **Dijkstra**

## The problem, in short

A signal starts at node k in a directed weighted graph. Return how long until every node receives it, or -1 if some never do.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/network-delay-time/](https://leetcode.com/problems/network-delay-time/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/012-network-delay-time.html](https://amitxaidev.github.io/dsa/23-graphs/012-network-delay-time.html)

## Understanding

**Really asking:** how long until a signal from k reaches every node?

**Why this works:** each node's arrival time is its shortest distance from k. Dijkstra with a min-heap finds them; the answer is the largest.

**Example:** edges 2→1 (1), 2→3 (1), 3→4 (1), k = 2
```text
dist: 1→1, 3→1, 4→2 → answer 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The time a node receives the signal is its shortest-path distance from k.

</details>

<details>
<summary>💡 Hint 2</summary>

Weights are positive — use Dijkstra with a min-heap.

</details>

<details>
<summary>💡 Hint 3</summary>

The answer is the largest of those distances.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Adjacency list, dist array filled with infinity, dist[k] = 0, heap of (dist, node). Pop the closest node; skip stale entries; relax its edges. Return max(dist) or −1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] t : times) adj.get(t[0]).add(new int[]{t[1], t[2]});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));   // {dist, node}
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], u = top[1];
            if (d > dist[u]) continue;            // stale entry
            for (int[] e : adj.get(u)) {
                int v = e[0], nd = d + e[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(E log V).
- **Space:** O(V + E).

## Common mistake

⚠️ Not skipping stale heap entries (d > dist[u]), which wastes time on outdated paths.

---

⬅️ [Previous: Is Graph Bipartite?](./011-is-graph-bipartite.md) · [📋 Graphs list](./README.md) · [Next: Path With Minimum Effort](./013-path-with-minimum-effort.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
