# 5. House Robber II

**LeetCode 213** · 🟡 Medium · Pattern: **1D DP on two ranges**

## The problem, in short

Same as House Robber, but the houses form a circle, so the first and last are adjacent.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/house-robber-ii/](https://leetcode.com/problems/house-robber-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/005-house-robber-ii.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/005-house-robber-ii.html)

## Understanding

**Really asking:** same, but the houses are in a circle.

**Why this works:** the first and last can't both be robbed, so solve without the last, solve without the first, and take the better.

**Example:** [2, 3, 2]
```text
without last [2, 3] → 3
without first [3, 2] → 3 → answer 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

You can't take both the first and the last house.

</details>

<details>
<summary>💡 Hint 2</summary>

Solve the straight-line problem twice: without the last house, and without the first. Take the better.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Reuse the linear robber on [0, n − 2] and [1, n − 1]. Handle n = 1 separately.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robLine(nums, 0, n - 2), robLine(nums, 1, n - 1));   // drop last or first
    }

    private int robLine(int[] nums, int lo, int hi) {
        int prev2 = 0, prev1 = 0;
        for (int i = lo; i <= hi; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting n = 1, where both ranges are empty and the answer is nums[0].

---

⬅️ [Previous: House Robber](./004-house-robber.md) · [📋 Dynamic Programming list](./README.md) · [Next: Unique Paths](./006-unique-paths.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
