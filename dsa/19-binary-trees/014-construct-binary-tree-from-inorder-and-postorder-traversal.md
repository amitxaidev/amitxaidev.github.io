# 14. Construct Binary Tree from Inorder and Postorder Traversal

**LeetCode 106** · 🟡 Medium · Pattern: **Divide by root position**

## The problem, in short

Rebuild a binary tree (with unique values) from its inorder and postorder traversals.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/014-construct-binary-tree-from-inorder-and-postorder-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/014-construct-binary-tree-from-inorder-and-postorder-traversal.html)

## Understanding

**Really asking:** rebuild from inorder and postorder.

**Why this works:** postorder's last value is the root. Read postorder backwards: root, then the right subtree, then the left.

**Example:** in [9, 3, 15, 20, 7], post [9, 15, 7, 20, 3]
```text
root 3 → build right from 20 (left 15, right 7) → then left 9
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The last postorder value is the root.

</details>

<details>
<summary>💡 Hint 2</summary>

Read postorder from the back: root, then the right subtree, then the left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Pointer starts at the end of postorder. build(lo, hi): take postorder[ptr--] as root, find its inorder index m, build the RIGHT subtree first (m + 1, hi), then left (lo, m − 1).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/**
 * class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    private int post;
    private int[] postorder;
    private final Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        post = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) pos.put(inorder[i], i);
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(postorder[post--]);
        int m = pos.get(root.val);
        root.right = build(m + 1, hi);    // right first when reading backwards
        root.left = build(lo, m - 1);
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Building left before right while reading postorder backwards.

---

⬅️ [Previous: Construct Binary Tree from Preorder and Inorder Traversal](./013-construct-binary-tree-from-preorder-and-inorder-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Maximum Width of Binary Tree](./015-maximum-width-of-binary-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
