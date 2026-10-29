# 17. Redundant Connection

**LeetCode 684** · 🟡 Medium · Pattern: **Union-Find**
🔗 Solve it here: [https://leetcode.com/problems/redundant-connection/](https://leetcode.com/problems/redundant-connection/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/017-redundant-connection.html](https://amitxaidev.github.io/dsa/23-graphs/017-redundant-connection.html)

## The problem, in short

A tree with n nodes had one extra edge added. Return an edge that can be removed to leave a tree (if several, the one that appears last in the input).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Add edges one by one with Union-Find.

</details>

<details>
<summary>💡 Hint 2</summary>

The first edge whose two ends are already connected creates the cycle.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

DSU with path compression and union by size. For each edge, if find(u) == find(v), return it; otherwise union them.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private int[] parent, size;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) { parent[i] = i; size[i] = 1; }
        for (int[] e : edges) {
            if (!union(e[0], e[1])) return e;   // already connected: this edge closes a cycle
        }
        return new int[0];
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];      // path compression (halving)
            x = parent[x];
        }
        return x;
    }

    private boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        size[ra] += size[rb];
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n · α(n)) ≈ O(n).
- **Space:** O(n).

## Common mistake

⚠️ Skipping path compression — still correct, but finds can become slow on long chains.

---

⬅️ [Previous: Min Cost to Connect All Points](./016-min-cost-to-connect-all-points.md) · [📋 Graphs list](./README.md) · [Next: Accounts Merge](./018-accounts-merge.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
