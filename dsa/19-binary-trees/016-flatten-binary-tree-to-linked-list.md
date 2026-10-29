# 16. Flatten Binary Tree to Linked List

**LeetCode 114** · 🟡 Medium · Pattern: **Morris-style rewiring**
🔗 Solve it here: [https://leetcode.com/problems/flatten-binary-tree-to-linked-list/](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/016-flatten-binary-tree-to-linked-list.html](https://amitxaidev.github.io/dsa/19-binary-trees/016-flatten-binary-tree-to-linked-list.html)

## The problem, in short

Flatten a binary tree into a "linked list" in place, using right pointers in preorder order and setting every left pointer to null.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For a node with a left subtree, its right subtree should come after the rightmost node of the left subtree.

</details>

<details>
<summary>💡 Hint 2</summary>

Attach the right subtree there, move the left subtree to the right, and continue.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk down the right spine. At each node with a left child: find the rightmost node of the left subtree, set its right to node.right, move node.left to node.right, and clear node.left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while (pre.right != null) pre = pre.right;   // end of the left subtree in preorder
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting to set left to null — the judge checks it.

---

⬅️ [Previous: Maximum Width of Binary Tree](./015-maximum-width-of-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Count Good Nodes in Binary Tree](./017-count-good-nodes-in-binary-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
