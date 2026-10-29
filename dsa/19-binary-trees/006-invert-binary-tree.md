# 6. Invert Binary Tree

**LeetCode 226** · 🟢 Easy · Pattern: **Swap children recursively**
🔗 Solve it here: [https://leetcode.com/problems/invert-binary-tree/](https://leetcode.com/problems/invert-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/006-invert-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/006-invert-binary-tree.html)

## The problem, in short

Mirror a binary tree by swapping every node's left and right children.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Invert both subtrees, then swap them.

</details>

<details>
<summary>💡 Hint 2</summary>

The order (swap first or recurse first) doesn't matter if you save references correctly.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Recursively invert left and right, then assign them crosswise.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);    // save both before assigning
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ root.left = invert(root.right); root.right = invert(root.left); — the second line reads the already-changed left.

---

⬅️ [Previous: Symmetric Tree](./005-symmetric-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Diameter of Binary Tree](./007-diameter-of-binary-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
