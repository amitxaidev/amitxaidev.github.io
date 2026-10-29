# 4. Range Sum of BST

**LeetCode 938** · 🟢 Easy · Pattern: **Pruned DFS**
🔗 Solve it here: [https://leetcode.com/problems/range-sum-of-bst/](https://leetcode.com/problems/range-sum-of-bst/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/004-range-sum-of-bst.html](https://amitxaidev.github.io/dsa/20-bst/004-range-sum-of-bst.html)

## The problem, in short

Return the sum of all node values in a BST that lie in the range [low, high].

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If a node is below low, its whole left subtree is too.

</details>

<details>
<summary>💡 Hint 2</summary>

If a node is above high, skip its right subtree.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

DFS that only goes left when node.val > low and only goes right when node.val &lt; high, adding values inside the range.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);   // left side too small
        if (root.val > high) return rangeSumBST(root.left, low, high);   // right side too big
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
```

</details>

## Complexity

- **Time:** O(n) worst case, much less when the range is narrow.
- **Space:** O(h).

## Common mistake

⚠️ Visiting every node — correct, but it ignores the BST property.

---

⬅️ [Previous: Minimum Absolute Difference in BST](./003-minimum-absolute-difference-in-bst.md) · [📋 Binary Search Trees list](./README.md) · [Next: Insert into a Binary Search Tree](./005-insert-into-a-binary-search-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
