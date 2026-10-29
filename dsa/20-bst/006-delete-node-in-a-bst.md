# 6. Delete Node in a BST

**LeetCode 450** · 🟡 Medium · Pattern: **Three deletion cases**
🔗 Solve it here: [https://leetcode.com/problems/delete-node-in-a-bst/](https://leetcode.com/problems/delete-node-in-a-bst/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/006-delete-node-in-a-bst.html](https://amitxaidev.github.io/dsa/20-bst/006-delete-node-in-a-bst.html)

## The problem, in short

Delete the node with a given key from a BST and return the new root.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Leaf or one child: replace the node with its child (or null).

</details>

<details>
<summary>💡 Hint 2</summary>

Two children: copy in the smallest value of the right subtree (the inorder successor), then delete that value from the right subtree.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Recurse to find the key. Handle the three cases. The successor is found by going right once and then left as far as possible.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;    // 0 or 1 child
            if (root.right == null) return root.left;
            TreeNode succ = root.right;
            while (succ.left != null) succ = succ.left;  // smallest on the right
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(h).
- **Space:** O(h).

## Common mistake

⚠️ Copying the successor's value but forgetting to delete the successor node, leaving a duplicate.

---

⬅️ [Previous: Insert into a Binary Search Tree](./005-insert-into-a-binary-search-tree.md) · [📋 Binary Search Trees list](./README.md) · [Next: Validate Binary Search Tree](./007-validate-binary-search-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
