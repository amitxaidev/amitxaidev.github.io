# 8. Balanced Binary Tree

**LeetCode 110** · 🟢 Easy · Pattern: **Height with early exit**

## The problem, in short

Decide whether every node's left and right subtree heights differ by at most 1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/balanced-binary-tree/](https://leetcode.com/problems/balanced-binary-tree/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/008-balanced-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/008-balanced-binary-tree.html)

## Understanding

**Really asking:** do the two subtree heights differ by at most 1 at every node?

**Why this works:** return the height, or -1 as soon as any subtree is unbalanced, so you never recompute.

**Example:** 1 (2 (3 (4)), -)
```text
node 2: heights 2 vs 0 → -1 → whole tree unbalanced
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Compute heights bottom-up.

</details>

<details>
<summary>💡 Hint 2</summary>

Return −1 as a signal that a subtree is already unbalanced.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

check(node) returns the height, or −1 if any subtree is unbalanced or this node's children differ by more than 1. The tree is balanced if check(root) != −1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int check(TreeNode n) {
        if (n == null) return 0;
        int l = check(n.left);
        if (l == -1) return -1;
        int r = check(n.right);
        if (r == -1 || Math.abs(l - r) > 1) return -1;   // unbalanced somewhere
        return 1 + Math.max(l, r);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Checking only the root's two subtrees — every node must be balanced.

---

⬅️ [Previous: Diameter of Binary Tree](./007-diameter-of-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Binary Tree Level Order Traversal](./009-binary-tree-level-order-traversal.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
