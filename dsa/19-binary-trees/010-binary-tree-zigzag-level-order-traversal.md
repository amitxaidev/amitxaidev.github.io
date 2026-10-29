# 10. Binary Tree Zigzag Level Order Traversal

**LeetCode 103** · 🟡 Medium · Pattern: **BFS with alternating direction**
🔗 Solve it here: [https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/010-binary-tree-zigzag-level-order-traversal.html](https://amitxaidev.github.io/dsa/19-binary-trees/010-binary-tree-zigzag-level-order-traversal.html)

## The problem, in short

Return level-order values, but alternate direction each level: left-to-right, then right-to-left, and so on.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Do normal BFS.

</details>

<details>
<summary>💡 Hint 2</summary>

For odd levels, add values at the front of the level list.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Level-order BFS with a flag. Use a LinkedList per level and addLast or addFirst depending on the flag.

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode n = q.poll();
                if (leftToRight) level.addLast(n.val);
                else level.addFirst(n.val);       // reverse only the output
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(w).

## Common mistake

⚠️ Changing the order you push children into the queue — that scrambles the next levels.

---

⬅️ [Previous: Binary Tree Level Order Traversal](./009-binary-tree-level-order-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Binary Tree Right Side View](./011-binary-tree-right-side-view.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
