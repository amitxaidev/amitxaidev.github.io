# 12. Recover Binary Search Tree

**LeetCode 99** · 🟡 Medium · Pattern: **Inorder to find swapped pair**
🔗 Solve it here: [https://leetcode.com/problems/recover-binary-search-tree/](https://leetcode.com/problems/recover-binary-search-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/012-recover-binary-search-tree.html](https://amitxaidev.github.io/dsa/20-bst/012-recover-binary-search-tree.html)

## The problem, in short

Exactly two nodes of a BST had their values swapped by mistake. Fix the tree without changing its structure.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The inorder sequence should be increasing. Swapping two values creates one or two "drops" (prev > cur).

</details>

<details>
<summary>💡 Hint 2</summary>

The first wrong node is prev at the first drop; the second is cur at the last drop.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Inorder traversal tracking prev. On each drop, set first (only once) to prev and second to cur. Swap their values at the end.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void inorder(TreeNode n) {
        if (n == null) return;
        inorder(n.left);
        if (prev != null && prev.val > n.val) {   // a drop in the sorted order
            if (first == null) first = prev;
            second = n;
        }
        prev = n;
        inorder(n.right);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h) (Morris traversal brings it to O(1)).

## Common mistake

⚠️ Assuming there are always two drops — adjacent swapped nodes create only one.

---

⬅️ [Previous: Construct Binary Search Tree from Preorder Traversal](./011-construct-binary-search-tree-from-preorder-traversal.md) · [📋 Binary Search Trees list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
