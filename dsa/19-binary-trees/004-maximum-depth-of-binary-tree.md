# 4. Maximum Depth of Binary Tree

**LeetCode 104** · 🟢 Easy · Pattern: **Recursive height**
🔗 Solve it here: [https://leetcode.com/problems/maximum-depth-of-binary-tree/](https://leetcode.com/problems/maximum-depth-of-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/004-maximum-depth-of-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/004-maximum-depth-of-binary-tree.html)

## The problem, in short

Return the number of nodes on the longest path from the root down to a leaf.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The depth of a tree is 1 + the larger depth of its two subtrees.

</details>

<details>
<summary>💡 Hint 2</summary>

An empty tree has depth 0.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Postorder recursion: compute both children's depths, return 1 + max.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Returning 1 for a null node, which adds one level to everything.

---

⬅️ [Previous: Binary Tree Postorder Traversal](./003-binary-tree-postorder-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Symmetric Tree](./005-symmetric-tree.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
