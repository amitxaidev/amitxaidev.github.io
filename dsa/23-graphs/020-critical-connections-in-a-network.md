# 20. Critical Connections in a Network

**LeetCode 1192** · 🔴 Hard · Pattern: **Tarjan's bridges**
🔗 Solve it here: [https://leetcode.com/problems/critical-connections-in-a-network/](https://leetcode.com/problems/critical-connections-in-a-network/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/020-critical-connections-in-a-network.html](https://amitxaidev.github.io/dsa/23-graphs/020-critical-connections-in-a-network.html)

## The problem, in short

In an undirected connected network, return every connection whose removal disconnects some servers (the bridges).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

DFS gives each node a discovery time.

</details>

<details>
<summary>💡 Hint 2</summary>

low[u] = the earliest discovery time reachable from u's subtree using at most one back edge.

</details>

<details>
<summary>💡 Hint 3</summary>

Edge (u, v) to a child v is a bridge when low[v] > disc[u].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Tarjan's algorithm: DFS with a timer. For each child v, recurse and set low[u] = min(low[u], low[v]); for a visited non-parent neighbour, low[u] = min(low[u], disc[v]). Record (u, v) if low[v] > disc[u].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private List<List<Integer>> adj;
    private int[] disc, low;
    private int timer = 1;
    private final List<List<Integer>> bridges = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> c : connections) {
            adj.get(c.get(0)).add(c.get(1));
            adj.get(c.get(1)).add(c.get(0));
        }
        disc = new int[n];   // 0 = not visited
        low = new int[n];
        dfs(0, -1);
        return bridges;
    }

    private void dfs(int u, int parent) {
        disc[u] = low[u] = timer++;
        for (int v : adj.get(u)) {
            if (v == parent) continue;                // don't use the edge we came from
            if (disc[v] == 0) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) bridges.add(Arrays.asList(u, v));   // v can't reach above u
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
```

</details>

## Complexity

- **Time:** O(V + E).
- **Space:** O(V + E).

## Common mistake

⚠️ Updating low through the parent edge, which hides every bridge.

---

⬅️ [Previous: Word Ladder](./019-word-ladder.md) · [📋 Graphs list](./README.md) · [Next: Swim in Rising Water](./021-swim-in-rising-water.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
