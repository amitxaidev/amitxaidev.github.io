# 11. Construct Binary Search Tree from Preorder Traversal

**LeetCode 1008** · 🟡 Medium · Pattern: **Upper-bound recursion**
🔗 Solve it here: [https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/011-construct-binary-search-tree-from-preorder-traversal.html](https://amitxaidev.github.io/dsa/20-bst/011-construct-binary-search-tree-from-preorder-traversal.html)

## The problem, in short

Rebuild a BST from its preorder traversal.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The first value is the root; following smaller values form the left subtree.

</details>

<details>
<summary>💡 Hint 2</summary>

Pass an upper bound: a node may be placed only if its value is below the bound.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep an index into preorder. build(bound): if the next value is above the bound (or none left), return null. Otherwise create the node, build left with bound = node.val, build right with the same outer bound.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] pre, int bound) {
        if (i == pre.length || pre[i] > bound) return null;
        TreeNode root = new TreeNode(pre[i++]);
        root.left = build(pre, root.val);   // left values must be smaller than root
        root.right = build(pre, bound);
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Inserting values one by one — O(n²) for skewed input.

---

⬅️ [Previous: Binary Search Tree Iterator](./010-binary-search-tree-iterator.md) · [📋 Binary Search Trees list](./README.md) · [Next: Recover Binary Search Tree](./012-recover-binary-search-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
