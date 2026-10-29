# 17. Count Good Nodes in Binary Tree

**LeetCode 1448** · 🟡 Medium · Pattern: **DFS carrying the path maximum**
🔗 Solve it here: [https://leetcode.com/problems/count-good-nodes-in-binary-tree/](https://leetcode.com/problems/count-good-nodes-in-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/017-count-good-nodes-in-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/017-count-good-nodes-in-binary-tree.html)

## The problem, in short

A node is "good" if no node on the path from the root to it has a greater value. Count the good nodes.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Pass the maximum value seen so far down the recursion.

</details>

<details>
<summary>💡 Hint 2</summary>

A node is good if its value is >= that maximum.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dfs(node, maxSoFar): count 1 if node.val >= maxSoFar, then recurse with max(maxSoFar, node.val).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode n, int maxSoFar) {
        if (n == null) return 0;
        int good = n.val >= maxSoFar ? 1 : 0;
        int m = Math.max(maxSoFar, n.val);       // passed by value: no undo needed
        return good + dfs(n.left, m) + dfs(n.right, m);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Using a shared variable for the maximum and not restoring it when returning from a subtree.

---

⬅️ [Previous: Flatten Binary Tree to Linked List](./016-flatten-binary-tree-to-linked-list.md) · [📋 Binary Trees list](./README.md) · [Next: Binary Tree Maximum Path Sum](./018-binary-tree-maximum-path-sum.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
