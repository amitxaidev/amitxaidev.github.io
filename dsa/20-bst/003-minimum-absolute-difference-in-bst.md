# 3. Minimum Absolute Difference in BST

**LeetCode 530** · 🟢 Easy · Pattern: **Inorder = sorted**

## The problem, in short

Return the smallest difference between the values of any two nodes in a BST.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/minimum-absolute-difference-in-bst/](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/003-minimum-absolute-difference-in-bst.html](https://amitxaidev.github.io/dsa/20-bst/003-minimum-absolute-difference-in-bst.html)

## Understanding

**Really asking:** the smallest difference between any two values.

**Why this works:** inorder gives sorted values; the closest pair is always neighbours in sorted order.

**Example:** 4 (2 (1, 3), 6)
```text
inorder 1, 2, 3, 4, 6 → gaps 1, 1, 1, 2 → 1
```

## Hints

<details>
<summary>💡 Hint 1</summary>

An inorder traversal of a BST visits values in sorted order.

</details>

<details>
<summary>💡 Hint 2</summary>

In a sorted list, the minimum difference is between neighbours.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Inorder traversal remembering the previous value; update the best with current − previous.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    private Integer prev = null;
    private int best = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return best;
    }

    private void inorder(TreeNode n) {
        if (n == null) return;
        inorder(n.left);
        if (prev != null) best = Math.min(best, n.val - prev);   // neighbours in sorted order
        prev = n.val;
        inorder(n.right);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Only comparing a node with its direct children — the closest value can be far away in the tree.

---

⬅️ [Previous: Convert Sorted Array to Binary Search Tree](./002-convert-sorted-array-to-binary-search-tree.md) · [📋 Binary Search Trees list](./README.md) · [Next: Range Sum of BST](./004-range-sum-of-bst.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
