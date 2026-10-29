# 18. Binary Tree Maximum Path Sum

**LeetCode 124** · 🔴 Hard · Pattern: **Gain function with global best**
🔗 Solve it here: [https://leetcode.com/problems/binary-tree-maximum-path-sum/](https://leetcode.com/problems/binary-tree-maximum-path-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/018-binary-tree-maximum-path-sum.html](https://amitxaidev.github.io/dsa/19-binary-trees/018-binary-tree-maximum-path-sum.html)

## The problem, in short

A path is any sequence of connected nodes, used at most once each, not necessarily through the root. Return the maximum sum of node values on any path.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For each node, compute the best "downward" gain: node value + the better child gain (or 0 if both are negative).

</details>

<details>
<summary>💡 Hint 2</summary>

A path that bends at a node = node + leftGain + rightGain. Update a global best with it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

gain(node) returns node.val + max(0, gain(left), gain(right)) — a path going down one side only. While computing it, update best with node.val + max(0, leftGain) + max(0, rightGain).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    private int best = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gain(root);
        return best;
    }

    private int gain(TreeNode n) {
        if (n == null) return 0;
        int l = Math.max(0, gain(n.left));     // drop negative branches
        int r = Math.max(0, gain(n.right));
        best = Math.max(best, n.val + l + r);  // path bending here
        return n.val + Math.max(l, r);         // parent can use only one side
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Returning the bent path (both children) to the parent — a parent can only extend a path down one side.

---

⬅️ [Previous: Count Good Nodes in Binary Tree](./017-count-good-nodes-in-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Serialize and Deserialize Binary Tree](./019-serialize-and-deserialize-binary-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
