# 8. Kth Smallest Element in a BST

**LeetCode 230** · 🟡 Medium · Pattern: **Inorder with a counter**

## The problem, in short

Return the k-th smallest value (1-indexed) in a BST.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/kth-smallest-element-in-a-bst/](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/008-kth-smallest-element-in-a-bst.html](https://amitxaidev.github.io/dsa/20-bst/008-kth-smallest-element-in-a-bst.html)

## Understanding

**Really asking:** the k-th smallest value.

**Why this works:** inorder visits values in increasing order; stop at the k-th visit.

**Example:** 3 (1 (-, 2), 4), k = 1
```text
inorder: 1 → first → answer 1
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Inorder traversal visits values in increasing order.

</details>

<details>
<summary>💡 Hint 2</summary>

Stop as soon as you've visited k nodes.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Iterative inorder with a stack; decrement k on each visit and return when it reaches 0.

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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (--k == 0) return cur.val;   // k-th visit in sorted order
            cur = cur.right;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(h + k).
- **Space:** O(h).

## Common mistake

⚠️ Collecting all values into a list first — O(n) even when k is small.

---

⬅️ [Previous: Validate Binary Search Tree](./007-validate-binary-search-tree.md) · [📋 Binary Search Trees list](./README.md) · [Next: Lowest Common Ancestor of a Binary Search Tree](./009-lowest-common-ancestor-of-a-binary-search-tree.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
