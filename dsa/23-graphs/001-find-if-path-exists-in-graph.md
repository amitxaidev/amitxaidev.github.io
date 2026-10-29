# 1. Find if Path Exists in Graph

**LeetCode 1971** · 🟢 Easy · Pattern: **Adjacency list + BFS**
🔗 Solve it here: [https://leetcode.com/problems/find-if-path-exists-in-graph/](https://leetcode.com/problems/find-if-path-exists-in-graph/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/001-find-if-path-exists-in-graph.html](https://amitxaidev.github.io/dsa/23-graphs/001-find-if-path-exists-in-graph.html)

## The problem, in short

An undirected graph has n vertices and an edge list. Decide whether a path exists from source to destination.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Build an adjacency list from the edge list.

</details>

<details>
<summary>💡 Hint 2</summary>

BFS or DFS from source with a visited array.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Adjacency list of size n, then BFS from source; return true when destination is reached. (Union-Find also works.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);   // undirected: both ways
        }
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        seen[source] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == destination) return true;
            for (int v : adj.get(u)) {
                if (!seen[v]) {
                    seen[v] = true;
                    q.offer(v);
                }
            }
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(V + E).
- **Space:** O(V + E).

## Common mistake

⚠️ Adding each undirected edge in only one direction.

---

[📋 Graphs list](./README.md) · [Next: Flood Fill](./002-flood-fill.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
