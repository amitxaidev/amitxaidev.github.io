# 9. Binary Tree Level Order Traversal

**LeetCode 102** · 🟡 Medium · Pattern: **BFS by levels**
🔗 Solve it here: [https://leetcode.com/problems/binary-tree-level-order-traversal/](https://leetcode.com/problems/binary-tree-level-order-traversal/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/009-binary-tree-level-order-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/009-binary-tree-level-order-traversal.html)

## The problem, in short

Return the node values level by level, from left to right.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Use a queue (BFS).

</details>

<details>
<summary>💡 Hint 2</summary>

At the start of each level, the queue size tells you how many nodes belong to it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

While the queue isn't empty, read size = queue.size(), poll exactly that many nodes into one list, and add their children.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();          // freeze the level size
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                level.add(n.val);
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            res.add(level);
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(w), w = maximum width.

## Common mistake

⚠️ Using queue.size() in the for-loop condition — it changes as you add children.

---

⬅️ [Previous: Balanced Binary Tree](./008-balanced-binary-tree.md) · [📋 Binary Trees list](./README.md) · [Next: Binary Tree Zigzag Level Order Traversal](./010-binary-tree-zigzag-level-order-traversal.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
