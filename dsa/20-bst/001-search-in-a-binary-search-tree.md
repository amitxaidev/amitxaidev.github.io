# 1. Search in a Binary Search Tree

**LeetCode 700** · 🟢 Easy · Pattern: **BST walk**
🔗 Solve it here: [https://leetcode.com/problems/search-in-a-binary-search-tree/](https://leetcode.com/problems/search-in-a-binary-search-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/001-search-in-a-binary-search-tree.html](https://amitxaidev.github.io/dsa/20-bst/001-search-in-a-binary-search-tree.html)

## The problem, in short

Find the node with a given value in a BST and return its subtree, or null.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Smaller values live on the left, larger on the right.

</details>

<details>
<summary>💡 Hint 2</summary>

You never need to search both sides.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk down from the root, going left or right by comparison, until you find the value or fall off the tree.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val) {
            cur = val < cur.val ? cur.left : cur.right;
        }
        return cur;
    }
}
```

</details>

## Complexity

- **Time:** O(h).
- **Space:** O(1) iterative.

## Common mistake

⚠️ Searching both subtrees like an ordinary binary tree — that throws away the BST advantage.

---

[📋 Binary Search Trees list](./README.md) · [Next: Convert Sorted Array to Binary Search Tree](./002-convert-sorted-array-to-binary-search-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
