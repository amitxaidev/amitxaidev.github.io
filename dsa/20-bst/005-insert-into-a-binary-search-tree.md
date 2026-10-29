# 5. Insert into a Binary Search Tree

**LeetCode 701** · 🟡 Medium · Pattern: **BST walk to a null slot**
🔗 Solve it here: [https://leetcode.com/problems/insert-into-a-binary-search-tree/](https://leetcode.com/problems/insert-into-a-binary-search-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/005-insert-into-a-binary-search-tree.html](https://amitxaidev.github.io/dsa/20-bst/005-insert-into-a-binary-search-tree.html)

## The problem, in short

Insert a new value (not already present) into a BST and return the root.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Walk down as if searching; the empty spot where the search ends is where the new node goes.

</details>

<details>
<summary>💡 Hint 2</summary>

Recursion makes the re-linking simple: root.left = insert(root.left, val).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

If root is null, return a new node. Otherwise recurse into the correct side and assign the result back.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(h).
- **Space:** O(h) recursion.

## Common mistake

⚠️ Forgetting to return a new node for an empty tree.

---

⬅️ [Previous: Range Sum of BST](./004-range-sum-of-bst.md) · [📋 Binary Search Trees list](./README.md) · [Next: Delete Node in a BST](./006-delete-node-in-a-bst.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
