# 7. Diameter of Binary Tree

**LeetCode 543** · 🟢 Easy · Pattern: **Height with a global best**
🔗 Solve it here: [https://leetcode.com/problems/diameter-of-binary-tree/](https://leetcode.com/problems/diameter-of-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/007-diameter-of-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/007-diameter-of-binary-tree.html)

## The problem, in short

Return the number of edges on the longest path between any two nodes of a binary tree (the path need not pass through the root).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The longest path through a node = height(left) + height(right).

</details>

<details>
<summary>💡 Hint 2</summary>

Compute heights bottom-up and update a global maximum along the way.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One postorder pass: height(node) returns 1 + max(child heights) and also updates best with leftHeight + rightHeight.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    private int best = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return best;
    }

    private int height(TreeNode n) {
        if (n == null) return 0;
        int l = height(n.left), r = height(n.right);
        best = Math.max(best, l + r);   // path bending at n
        return 1 + Math.max(l, r);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Calling a separate height function at every node — O(n²) on a skewed tree.

---

⬅️ [Previous: Invert Binary Tree](./006-invert-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Balanced Binary Tree](./008-balanced-binary-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
