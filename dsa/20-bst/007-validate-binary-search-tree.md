# 7. Validate Binary Search Tree

**LeetCode 98** · 🟡 Medium · Pattern: **Bounds passed down**
🔗 Solve it here: [https://leetcode.com/problems/validate-binary-search-tree/](https://leetcode.com/problems/validate-binary-search-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/007-validate-binary-search-tree.html](https://amitxaidev.github.io/dsa/20-bst/007-validate-binary-search-tree.html)

## The problem, in short

Decide whether a binary tree is a valid BST: every node is strictly greater than all nodes in its left subtree and strictly less than all in its right subtree.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Checking only a node against its children is not enough.

</details>

<details>
<summary>💡 Hint 2</summary>

Pass down an allowed (min, max) range for each node.

</details>

<details>
<summary>💡 Hint 3</summary>

Use long bounds (or null) because node values can equal Integer.MIN_VALUE / MAX_VALUE.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

valid(node, lo, hi): node.val must be in (lo, hi). Left child gets (lo, node.val), right child gets (node.val, hi).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode n, long lo, long hi) {
        if (n == null) return true;
        if (n.val <= lo || n.val >= hi) return false;
        return valid(n.left, lo, n.val) && valid(n.right, n.val, hi);   // tighten the range
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Comparing only with the direct parent — a deep right descendant of a left child can still be too large.

---

⬅️ [Previous: Delete Node in a BST](./006-delete-node-in-a-bst.md) · [📋 Binary Search Trees list](./README.md) · [Next: Kth Smallest Element in a BST](./008-kth-smallest-element-in-a-bst.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
