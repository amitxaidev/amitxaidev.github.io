# 15. Maximum Width of Binary Tree

**LeetCode 662** · 🟡 Medium · Pattern: **BFS with position indexes**
🔗 Solve it here: [https://leetcode.com/problems/maximum-width-of-binary-tree/](https://leetcode.com/problems/maximum-width-of-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/015-maximum-width-of-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/015-maximum-width-of-binary-tree.html)

## The problem, in short

The width of a level is the distance between its leftmost and rightmost non-null nodes, counting the null gaps in between. Return the maximum width.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Number nodes like a heap: children of i are 2i and 2i + 1.

</details>

<details>
<summary>💡 Hint 2</summary>

Width of a level = last index − first index + 1.

</details>

<details>
<summary>💡 Hint 3</summary>

Re-base indexes at each level to stop them growing huge.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

BFS storing (node, index). For each level, subtract the first index of the level from every index before computing children, then width = last − first + 1.

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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        Queue<Long> idx = new ArrayDeque<>();
        nodes.offer(root);
        idx.offer(0L);
        int best = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            long first = idx.peek(), last = first;
            for (int i = 0; i < size; i++) {
                TreeNode n = nodes.poll();
                long p = idx.poll() - first;   // re-base to keep numbers small
                last = p;
                if (n.left != null) { nodes.offer(n.left); idx.offer(2 * p); }
                if (n.right != null) { nodes.offer(n.right); idx.offer(2 * p + 1); }
            }
            best = Math.max(best, (int) last + 1);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(w).

## Common mistake

⚠️ Letting indexes double every level — they overflow on deep skewed trees.

---

⬅️ [Previous: Construct Binary Tree from Inorder and Postorder Traversal](./014-construct-binary-tree-from-inorder-and-postorder-traversal.md) · [📋 Binary Trees list](./README.md) · [Next: Flatten Binary Tree to Linked List](./016-flatten-binary-tree-to-linked-list.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
