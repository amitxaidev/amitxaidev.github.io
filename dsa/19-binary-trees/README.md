# 19 · Binary Trees

Traversals, BFS, height/diameter, views, LCA, construction and serialization.

📺 **Watch first:** Ep 53, Ep 54, Ep 55, Ep 56, Ep 57, Ep 58, Ep 59, Ep 60 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/19-binary-trees/  
🧮 **20 problems** · 🟢 8 Easy · 🟡 9 Medium · 🔴 3 Hard

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [94. Binary Tree Inorder Traversal](./001-binary-tree-inorder-traversal.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-inorder-traversal/) | 🟢 Easy | Iterative inorder with a stack | ⬜ |
| 2 | [144. Binary Tree Preorder Traversal](./002-binary-tree-preorder-traversal.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-preorder-traversal/) | 🟢 Easy | Iterative preorder with a stack | ⬜ |
| 3 | [145. Binary Tree Postorder Traversal](./003-binary-tree-postorder-traversal.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-postorder-traversal/) | 🟢 Easy | Reverse of modified preorder | ⬜ |
| 4 | [104. Maximum Depth of Binary Tree](./004-maximum-depth-of-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | 🟢 Easy | Recursive height | ⬜ |
| 5 | [101. Symmetric Tree](./005-symmetric-tree.md) | [Solve ↗](https://leetcode.com/problems/symmetric-tree/) | 🟢 Easy | Mirror recursion | ⬜ |
| 6 | [226. Invert Binary Tree](./006-invert-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/invert-binary-tree/) | 🟢 Easy | Swap children recursively | ⬜ |
| 7 | [543. Diameter of Binary Tree](./007-diameter-of-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/diameter-of-binary-tree/) | 🟢 Easy | Height with a global best | ⬜ |
| 8 | [110. Balanced Binary Tree](./008-balanced-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/balanced-binary-tree/) | 🟢 Easy | Height with early exit | ⬜ |
| 9 | [102. Binary Tree Level Order Traversal](./009-binary-tree-level-order-traversal.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-level-order-traversal/) | 🟡 Medium | BFS by levels | ⬜ |
| 10 | [103. Binary Tree Zigzag Level Order Traversal](./010-binary-tree-zigzag-level-order-traversal.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | 🟡 Medium | BFS with alternating direction | ⬜ |
| 11 | [199. Binary Tree Right Side View](./011-binary-tree-right-side-view.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-right-side-view/) | 🟡 Medium | Rightmost per level | ⬜ |
| 12 | [236. Lowest Common Ancestor of a Binary Tree](./012-lowest-common-ancestor-of-a-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | 🟡 Medium | Postorder search | ⬜ |
| 13 | [105. Construct Binary Tree from Preorder and Inorder Traversal](./013-construct-binary-tree-from-preorder-and-inorder-traversal.md) | [Solve ↗](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | 🟡 Medium | Divide by root position | ⬜ |
| 14 | [106. Construct Binary Tree from Inorder and Postorder Traversal](./014-construct-binary-tree-from-inorder-and-postorder-traversal.md) | [Solve ↗](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | 🟡 Medium | Divide by root position | ⬜ |
| 15 | [662. Maximum Width of Binary Tree](./015-maximum-width-of-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/maximum-width-of-binary-tree/) | 🟡 Medium | BFS with position indexes | ⬜ |
| 16 | [114. Flatten Binary Tree to Linked List](./016-flatten-binary-tree-to-linked-list.md) | [Solve ↗](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | 🟡 Medium | Morris-style rewiring | ⬜ |
| 17 | [1448. Count Good Nodes in Binary Tree](./017-count-good-nodes-in-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) | 🟡 Medium | DFS carrying the path maximum | ⬜ |
| 18 | [124. Binary Tree Maximum Path Sum](./018-binary-tree-maximum-path-sum.md) | [Solve ↗](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | 🔴 Hard | Gain function with global best | ⬜ |
| 19 | [297. Serialize and Deserialize Binary Tree](./019-serialize-and-deserialize-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | 🔴 Hard | Preorder with null markers | ⬜ |
| 20 | [987. Vertical Order Traversal of a Binary Tree](./020-vertical-order-traversal-of-a-binary-tree.md) | [Solve ↗](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/) | 🔴 Hard | Coordinates + sort | ⬜ |

---

[🏠 Back to the full roadmap](../../README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
