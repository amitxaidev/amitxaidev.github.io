# 11. Binary Tree Right Side View

**LeetCode 199** · 🟡 Medium · Pattern: **Rightmost per level**
🔗 Solve it here: [https://leetcode.com/problems/binary-tree-right-side-view/](https://leetcode.com/problems/binary-tree-right-side-view/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/011-binary-tree-right-side-view.html](https://amitxaidev.github.io/dsa/19-binary-trees/011-binary-tree-right-side-view.html)

## The problem, in short

Imagine standing to the right of the tree. Return the values you can see, from top to bottom.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You see exactly one node per level: the rightmost.

</details>

<details>
<summary>💡 Hint 2</summary>

DFS visiting right before left: the first node you reach at each depth is the visible one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

DFS(node, depth) with right child first. If depth == result size, this is the first node seen at that depth — add it.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode n, int depth, List<Integer> res) {
        if (n == null) return;
        if (depth == res.size()) res.add(n.val);   // first node at this depth
        dfs(n.right, depth + 1, res);              // right first
        dfs(n.left, depth + 1, res);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Only following right children — a deeper left subtree can be visible below a short right side.

---

⬅️ [Previous: Binary Tree Zigzag Level Order Traversal](./010-binary-tree-zigzag-level-order-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Lowest Common Ancestor of a Binary Tree](./012-lowest-common-ancestor-of-a-binary-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
