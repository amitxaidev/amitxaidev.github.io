# 2. Binary Tree Preorder Traversal

**LeetCode 144** · 🟢 Easy · Pattern: **Iterative preorder with a stack**
🔗 Solve it here: [https://leetcode.com/problems/binary-tree-preorder-traversal/](https://leetcode.com/problems/binary-tree-preorder-traversal/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/002-binary-tree-preorder-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/002-binary-tree-preorder-traversal.html)

## The problem, in short

Return the values of a binary tree in preorder (node, left subtree, right subtree).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Visit a node as soon as you pop it.

</details>

<details>
<summary>💡 Hint 2</summary>

Push the right child before the left so the left is processed first.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Stack starts with root. Pop, record, push right then left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            res.add(n.val);
            if (n.right != null) st.push(n.right);   // right first, so left pops first
            if (n.left != null) st.push(n.left);
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Pushing left before right, which produces node-right-left order.

---

⬅️ [Previous: Binary Tree Inorder Traversal](./001-binary-tree-inorder-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Binary Tree Postorder Traversal](./003-binary-tree-postorder-traversal.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
