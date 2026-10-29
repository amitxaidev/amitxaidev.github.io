# 1. Binary Tree Inorder Traversal

**LeetCode 94** · 🟢 Easy · Pattern: **Iterative inorder with a stack**

## The problem, in short

Return the values of a binary tree in inorder (left subtree, node, right subtree).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/binary-tree-inorder-traversal/](https://leetcode.com/problems/binary-tree-inorder-traversal/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/001-binary-tree-inorder-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/001-binary-tree-inorder-traversal.html)

## Understanding

**Really asking:** list nodes as left subtree, node, right subtree.

**Why this works:** the iterative version pushes all left children, pops one, visits it, then moves to its right child.

**Example:** 1 with right child 2, and 2 has left child 3
```text
go left from 1: none → visit 1
go to 2 → left 3 → visit 3, visit 2
[1, 3, 2]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The recursive version is three lines. Try the iterative one too.

</details>

<details>
<summary>💡 Hint 2</summary>

Go left as far as possible, pushing nodes. Pop one, visit it, then go to its right child.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

cur = root. While cur or the stack is non-empty: push all left children, pop the top, record it, set cur to its right child.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/**
 * Definition for a binary tree node (provided by LeetCode):
 * class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {        // go all the way left
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);            // visit between left and right
            cur = cur.right;
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h), h = tree height.

## Common mistake

⚠️ Visiting the node when it's pushed — that's preorder, not inorder.

---

[📋 Binary Trees list](./README.md) · [Next: Binary Tree Preorder Traversal](./002-binary-tree-preorder-traversal.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
