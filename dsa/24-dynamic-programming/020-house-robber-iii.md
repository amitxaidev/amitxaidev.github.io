# 20. House Robber III

**LeetCode 337** · 🟡 Medium · Pattern: **DP on trees**
🔗 Solve it here: [https://leetcode.com/problems/house-robber-iii/](https://leetcode.com/problems/house-robber-iii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/020-house-robber-iii.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/020-house-robber-iii.html)

## The problem, in short

Houses form a binary tree; robbing two directly linked houses triggers the alarm. Return the most money you can rob.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For each node return two numbers: best if you rob it, best if you don't.

</details>

<details>
<summary>💡 Hint 2</summary>

Rob node → children must be skipped. Skip node → each child can be robbed or not, whichever is better.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Postorder DFS returning {robbed, skipped}. robbed = val + left.skipped + right.skipped; skipped = max(left) + max(right).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class TreeNode { int val; TreeNode left, right; }  // provided by LeetCode
 */
class Solution {
    public int rob(TreeNode root) {
        int[] r = dfs(root);
        return Math.max(r[0], r[1]);
    }

    // returns {best if this node is robbed, best if it is not}
    private int[] dfs(TreeNode n) {
        if (n == null) return new int[]{0, 0};
        int[] l = dfs(n.left), r = dfs(n.right);
        int robbed = n.val + l[1] + r[1];
        int skipped = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{robbed, skipped};
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(h).

## Common mistake

⚠️ Plain recursion that tries grandchildren directly without returning both states — exponential.

---

⬅️ [Previous: Word Break](./019-word-break.md) · [📋 Dynamic Programming list](./README.md) · [Next: Beautiful Arrangement](./021-beautiful-arrangement.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
