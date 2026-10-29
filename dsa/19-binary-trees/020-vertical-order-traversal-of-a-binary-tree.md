# 20. Vertical Order Traversal of a Binary Tree

**LeetCode 987** · 🔴 Hard · Pattern: **Coordinates + sort**

## The problem, in short

Give each node a (row, column): the root is (0, 0), a left child is (row + 1, col − 1), a right child is (row + 1, col + 1). Return values column by column from left to right; inside a column sort by row, and break ties by value.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/020-vertical-order-traversal-of-a-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/020-vertical-order-traversal-of-a-binary-tree.html)

## Understanding

**Really asking:** group nodes by column, sorted by row then value.

**Why this works:** give each node (col, row); left child col - 1, right col + 1. Sort all triples and group by column.

**Example:** 3 (9, 20 (15, 7))
```text
col -1: [9], col 0: [3, 15], col 1: [20], col 2: [7]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Record (col, row, value) for every node with DFS.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort by column, then row, then value.

</details>

<details>
<summary>💡 Hint 3</summary>

Group consecutive entries with the same column.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Collect triples, sort them with a three-key comparator, then walk the sorted list starting a new group whenever the column changes. This is the LeetCode version of "top/bottom view" style problems.

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> cells = new ArrayList<>();   // {col, row, val}
        dfs(root, 0, 0, cells);
        cells.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                           : a[1] != b[1] ? Integer.compare(a[1], b[1])
                           : Integer.compare(a[2], b[2]));
        List<List<Integer>> res = new ArrayList<>();
        Integer lastCol = null;
        for (int[] c : cells) {
            if (lastCol == null || c[0] != lastCol) {   // new column starts
                res.add(new ArrayList<>());
                lastCol = c[0];
            }
            res.get(res.size() - 1).add(c[2]);
        }
        return res;
    }

    private void dfs(TreeNode n, int row, int col, List<int[]> cells) {
        if (n == null) return;
        cells.add(new int[]{col, row, n.val});
        dfs(n.left, row + 1, col - 1, cells);
        dfs(n.right, row + 1, col + 1, cells);
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Ignoring the value tie-break when two nodes share both row and column.

---

⬅️ [Previous: Serialize and Deserialize Binary Tree](./019-serialize-and-deserialize-binary-tree.md) · [📋 Binary Trees list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
