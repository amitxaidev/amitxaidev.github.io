# 10. Binary Search Tree Iterator

**LeetCode 173** · 🟡 Medium · Pattern: **Controlled inorder with a stack**

## The problem, in short

Build an iterator over a BST that returns values in increasing order with next() and hasNext(), using O(h) memory.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/binary-search-tree-iterator/](https://leetcode.com/problems/binary-search-tree-iterator/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/010-binary-search-tree-iterator.html](https://amitxaidev.github.io/dsa/20-bst/010-binary-search-tree-iterator.html)

## Understanding

**Really asking:** return values in sorted order one at a time using O(h) memory.

**Why this works:** keep only the left spine on a stack (a paused inorder traversal); after popping a node, push the left spine of its right child.

**Example:** 7 (3, 15 (9, 20))
```text
stack [7, 3] → next 3
next 7 → push 15, 9 → next 9, 15, 20
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Store only the path of left children, like an iterative inorder paused between steps.

</details>

<details>
<summary>💡 Hint 2</summary>

next(): pop a node, then push the left spine of its right child.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Constructor pushes the left spine of the root. next pops the top, pushes the left spine of its right subtree, and returns the value. hasNext checks the stack.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class BSTIterator {
    private final Deque<TreeNode> st = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    public int next() {
        TreeNode n = st.pop();
        pushLeft(n.right);      // next smallest values are in the right subtree
        return n.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushLeft(TreeNode n) {
        while (n != null) {
            st.push(n);
            n = n.left;
        }
    }
}
```

</details>

## Complexity

- **Time:** Amortised O(1) per next().
- **Space:** O(h).

## Common mistake

⚠️ Flattening the whole tree into a list in the constructor — O(n) memory.

---

⬅️ [Previous: Lowest Common Ancestor of a Binary Search Tree](./009-lowest-common-ancestor-of-a-binary-search-tree.md) · [📋 Binary Search Trees list](./README.md) · [Next: Construct Binary Search Tree from Preorder Traversal](./011-construct-binary-search-tree-from-preorder-traversal.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
