# 13. Construct Binary Tree from Preorder and Inorder Traversal

**LeetCode 105** · 🟡 Medium · Pattern: **Divide by root position**
🔗 Solve it here: [https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/013-construct-binary-tree-from-preorder-and-inorder-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/013-construct-binary-tree-from-preorder-and-inorder-traversal.html)

## The problem, in short

Rebuild a binary tree (with unique values) from its preorder and inorder traversals.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The first preorder value is the root.

</details>

<details>
<summary>💡 Hint 2</summary>

In inorder, everything left of the root is the left subtree.

</details>

<details>
<summary>💡 Hint 3</summary>

Store inorder positions in a HashMap for O(1) lookup.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a pointer into preorder. build(lo, hi) over the inorder range: take the next preorder value as the root, find its inorder index m, build left from (lo, m − 1) then right from (m + 1, hi).

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
    private int pre = 0;
    private int[] preorder;
    private final Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) pos.put(inorder[i], i);
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(preorder[pre++]);
        int m = pos.get(root.val);
        root.left = build(lo, m - 1);     // left first: matches preorder
        root.right = build(m + 1, hi);
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Building the right subtree before the left — preorder lists the left subtree first.

---

⬅️ [Previous: Lowest Common Ancestor of a Binary Tree](./012-lowest-common-ancestor-of-a-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Construct Binary Tree from Inorder and Postorder Traversal](./014-construct-binary-tree-from-inorder-and-postorder-traversal.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
