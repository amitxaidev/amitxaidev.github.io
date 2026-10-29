# 9. Lowest Common Ancestor of a Binary Search Tree

**LeetCode 235** · 🟡 Medium · Pattern: **Split point**
🔗 Solve it here: [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/009-lowest-common-ancestor-of-a-binary-search-tree.html](https://amitxaidev.github.io/dsa/20-bst/009-lowest-common-ancestor-of-a-binary-search-tree.html)

## The problem, in short

Return the lowest common ancestor of two nodes p and q in a BST.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If both values are smaller than the current node, the LCA is on the left.

</details>

<details>
<summary>💡 Hint 2</summary>

If both are larger, it's on the right. Otherwise, the current node is where they split.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk down from the root using the comparisons above. The first node where p and q are not on the same side (or equal to one of them) is the LCA.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (true) {
            if (p.val < cur.val && q.val < cur.val) cur = cur.left;
            else if (p.val > cur.val && q.val > cur.val) cur = cur.right;
            else return cur;   // they split here
        }
    }
}
```

</details>

## Complexity

- **Time:** O(h).
- **Space:** O(1).

## Common mistake

⚠️ Using the general binary-tree LCA — it works but doesn't use the BST ordering.

---

⬅️ [Previous: Kth Smallest Element in a BST](./008-kth-smallest-element-in-a-bst.md) · [📋 Binary Search Trees list](./README.md) · [Next: Binary Search Tree Iterator](./010-binary-search-tree-iterator.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
