# 12. Lowest Common Ancestor of a Binary Tree

**LeetCode 236** · 🟡 Medium · Pattern: **Postorder search**
🔗 Solve it here: [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/012-lowest-common-ancestor-of-a-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/012-lowest-common-ancestor-of-a-binary-tree.html)

## The problem, in short

Given two nodes p and q in a binary tree, return their lowest common ancestor (a node may be an ancestor of itself).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Search both subtrees for p or q.

</details>

<details>
<summary>💡 Hint 2</summary>

If both sides return something, the current node is the split point — the LCA.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

lca(node): if null or equal to p or q, return node. Recurse left and right. If both non-null, return node; otherwise return whichever is non-null.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;   // p and q on different sides
        return left != null ? left : right;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Storing full root-to-node paths in lists — works, but uses more memory and code.

---

⬅️ [Previous: Binary Tree Right Side View](./011-binary-tree-right-side-view.md) · [📋 Binary Trees list](./README.md) · [Next: Construct Binary Tree from Preorder and Inorder Traversal](./013-construct-binary-tree-from-preorder-and-inorder-traversal.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
