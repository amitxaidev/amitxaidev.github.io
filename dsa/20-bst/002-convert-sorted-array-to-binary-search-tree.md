# 2. Convert Sorted Array to Binary Search Tree

**LeetCode 108** · 🟢 Easy · Pattern: **Middle as root**

## The problem, in short

Turn a sorted array into a height-balanced BST.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/20-bst/002-convert-sorted-array-to-binary-search-tree.html](https://amitxaidev.github.io/dsa/20-bst/002-convert-sorted-array-to-binary-search-tree.html)

## Understanding

**Really asking:** build a height-balanced BST from a sorted array.

**Why this works:** the middle value as root splits the rest evenly; repeat on both halves.

**Example:** [-10, -3, 0, 5, 9]
```text
root 0, left from [-10, -3] → -3 (-10), right from [5, 9] → 9 (5)
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The middle element should be the root so both sides have equal size.

</details>

<details>
<summary>💡 Hint 2</summary>

Apply the same idea to the left half and right half.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

build(lo, hi): mid = (lo + hi) / 2 becomes the node; left = build(lo, mid − 1), right = build(mid + 1, hi).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] a, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) >>> 1;
        TreeNode root = new TreeNode(a[mid]);   // middle keeps it balanced
        root.left = build(a, lo, mid - 1);
        root.right = build(a, mid + 1, hi);
        return root;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(log n) recursion.

## Common mistake

⚠️ Inserting elements one by one in order — that builds a linked-list-shaped tree.

---

⬅️ [Previous: Search in a Binary Search Tree](./001-search-in-a-binary-search-tree.md) · [📋 Binary Search Trees list](./README.md) · [Next: Minimum Absolute Difference in BST](./003-minimum-absolute-difference-in-bst.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
