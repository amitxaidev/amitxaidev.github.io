# 3. Binary Tree Postorder Traversal

**LeetCode 145** · 🟢 Easy · Pattern: **Reverse of modified preorder**
🔗 Solve it here: [https://leetcode.com/problems/binary-tree-postorder-traversal/](https://leetcode.com/problems/binary-tree-postorder-traversal/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/003-binary-tree-postorder-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/003-binary-tree-postorder-traversal.html)

## The problem, in short

Return the values of a binary tree in postorder (left subtree, right subtree, node).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Postorder reversed is node-right-left.

</details>

<details>
<summary>💡 Hint 2</summary>

Node-right-left is preorder with the children pushed the other way round.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Run the stack preorder but push left before right, adding each value to the front of a LinkedList. The result is left-right-node.

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            res.addFirst(n.val);                   // build the answer backwards
            if (n.left != null) st.push(n.left);
            if (n.right != null) st.push(n.right);
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h) for the stack plus the output.

## Common mistake

⚠️ Trying the one-stack "true" postorder without tracking the last visited node — easy to loop forever.

---

⬅️ [Previous: Binary Tree Preorder Traversal](./002-binary-tree-preorder-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Maximum Depth of Binary Tree](./004-maximum-depth-of-binary-tree.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
