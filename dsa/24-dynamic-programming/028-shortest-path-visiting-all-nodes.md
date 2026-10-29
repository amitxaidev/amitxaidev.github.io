# 28. Shortest Path Visiting All Nodes

**LeetCode 847** · 🔴 Hard · Pattern: **BFS over (node, visited-mask)**
🔗 Solve it here: [https://leetcode.com/problems/shortest-path-visiting-all-nodes/](https://leetcode.com/problems/shortest-path-visiting-all-nodes/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/028-shortest-path-visiting-all-nodes.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/028-shortest-path-visiting-all-nodes.html)

## The problem, in short

In a connected undirected graph with n ≤ 12 nodes, return the length of the shortest walk that visits every node (you can start and end anywhere and reuse nodes and edges).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The state is (current node, set of visited nodes) — a bitmask.

</details>

<details>
<summary>💡 Hint 2</summary>

All edges have length 1, so BFS over states finds the shortest walk.

</details>

<details>
<summary>💡 Hint 3</summary>

Start from every node at once.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Multi-source BFS with states (node, mask) and a seen[node][mask] table. The first time a state has all bits set, its distance is the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, full = (1 << n) - 1;
        boolean[][] seen = new boolean[n][1 << n];
        Queue<int[]> q = new ArrayDeque<>();   // {node, mask}
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i});
            seen[i][1 << i] = true;
        }
        for (int steps = 0; !q.isEmpty(); steps++) {
            for (int s = q.size(); s > 0; s--) {
                int[] cur = q.poll();
                if (cur[1] == full) return steps;
                for (int v : graph[cur[0]]) {
                    int mask = cur[1] | (1 << v);
                    if (!seen[v][mask]) {
                        seen[v][mask] = true;
                        q.offer(new int[]{v, mask});
                    }
                }
            }
        }
        return 0;
    }
}
```

</details>

## Complexity

- **Time:** O(n² · 2^n).
- **Space:** O(n · 2^n).

## Common mistake

⚠️ Marking only nodes as visited — you must be allowed to revisit a node with a different mask.

---

⬅️ [Previous: Minimum Cost to Cut a Stick](./027-minimum-cost-to-cut-a-stick.md) · [📋 Dynamic Programming list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
