# 5. Symmetric Tree

**LeetCode 101** · 🟢 Easy · Pattern: **Mirror recursion**
🔗 Solve it here: [https://leetcode.com/problems/symmetric-tree/](https://leetcode.com/problems/symmetric-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/005-symmetric-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/005-symmetric-tree.html)

## The problem, in short

Decide whether a binary tree is a mirror image of itself around its centre.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compare the left subtree with the right subtree as mirrors.

</details>

<details>
<summary>💡 Hint 2</summary>

Two trees are mirrors if their roots match, a.left mirrors b.right, and a.right mirrors b.left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Helper mirror(a, b): both null → true; one null → false; else values equal and mirror(a.left, b.right) and mirror(a.right, b.left).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && mirror(a.left, b.right) && mirror(a.right, b.left);   // outside & inside pairs
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Comparing a.left with b.left — that checks equality, not mirroring.

---

⬅️ [Previous: Maximum Depth of Binary Tree](./004-maximum-depth-of-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Invert Binary Tree](./006-invert-binary-tree.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
