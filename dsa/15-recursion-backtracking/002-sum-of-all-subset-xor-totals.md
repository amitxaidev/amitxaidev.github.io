# 2. Sum of All Subset XOR Totals

**LeetCode 1863** · 🟢 Easy · Pattern: **Pick / not pick recursion**

## The problem, in short

For every subset of the array, take the XOR of its elements. Return the sum of all those XOR values.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sum-of-all-subset-xor-totals/](https://leetcode.com/problems/sum-of-all-subset-xor-totals/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/002-sum-of-all-subset-xor-totals.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/002-sum-of-all-subset-xor-totals.html)

## Understanding

**Really asking:** XOR each subset, add all those results.

**Why this works:** every element is either in or out — two branches. At the end of the array you have one finished subset.

**Example:** [1, 3]
```text
{} → 0, {1} → 1, {3} → 3, {1,3} → 2
total 6
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Each element is either in the subset or not — two recursive branches.

</details>

<details>
<summary>💡 Hint 2</summary>

Carry the XOR so far down the recursion; at the end of the array, return it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dfs(i, cur) = dfs(i+1, cur ^ nums[i]) + dfs(i+1, cur). At i == n return cur. This visits all 2^n subsets. (A bit trick also gives OR-of-all × 2^(n−1), but the recursion is the point here.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int i, int cur) {
        if (i == nums.length) return cur;          // one complete subset
        return dfs(nums, i + 1, cur ^ nums[i])     // pick nums[i]
             + dfs(nums, i + 1, cur);              // skip nums[i]
    }
}
```

</details>

## Complexity

- **Time:** O(2^n).
- **Space:** O(n) recursion depth.

## Common mistake

⚠️ Forgetting the empty subset is included — it contributes 0, so it's harmless, but the base case must still return.

---

⬅️ [Previous: Fibonacci Number](./001-fibonacci-number.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Subsets](./003-subsets.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
