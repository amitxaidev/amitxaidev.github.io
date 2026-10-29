# 8. Clone Graph

**LeetCode 133** · 🟡 Medium · Pattern: **DFS with old → new map**

## The problem, in short

Return a deep copy of a connected undirected graph, given a reference to one node.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/clone-graph/](https://leetcode.com/problems/clone-graph/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/008-clone-graph.html](https://amitxaidev.github.io/dsa/23-graphs/008-clone-graph.html)

## Understanding

**Really asking:** deep-copy a graph.

**Why this works:** map each original node to its copy; register the copy before visiting neighbours so cycles stop.

**Example:** 1 - 2 - 3 - 4 - 1 (a square)
```text
copy 1 → copy neighbours 2 and 4 → … each node copied once
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep a HashMap from original node to its copy.

</details>

<details>
<summary>💡 Hint 2</summary>

Put the copy in the map before visiting neighbours, so cycles stop there.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

clone(node): if mapped, return the copy. Otherwise create the copy, store it, and add clone(neighbour) for every neighbour.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/*
 * class Node { int val; List<Node> neighbors; Node(int v) { ... } }  // provided by LeetCode
 */
class Solution {
    private final Map<Node, Node> copies = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node existing = copies.get(node);
        if (existing != null) return existing;
        Node copy = new Node(node.val);
        copies.put(node, copy);                       // register before recursing
        for (Node nb : node.neighbors) copy.neighbors.add(cloneGraph(nb));
        return copy;
    }
}
```

</details>

## Complexity

- **Time:** O(V + E).
- **Space:** O(V).

## Common mistake

⚠️ Adding to the map after cloning neighbours — cycles then recurse forever.

---

⬅️ [Previous: Pacific Atlantic Water Flow](./007-pacific-atlantic-water-flow.md) · [📋 Graphs list](./README.md) · [Next: Course Schedule](./009-course-schedule.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
