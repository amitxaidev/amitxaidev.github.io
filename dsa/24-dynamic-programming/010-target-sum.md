# 10. Target Sum

**LeetCode 494** · 🟡 Medium · Pattern: **0/1 knapsack (count subsets)**
🔗 Solve it here: [https://leetcode.com/problems/target-sum/](https://leetcode.com/problems/target-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/010-target-sum.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/010-target-sum.html)

## The problem, in short

Put + or − in front of every number. Count the sign choices that make the expression equal target.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Let P = numbers with +, N = numbers with −. P − N = target and P + N = total.

</details>

<details>
<summary>💡 Hint 2</summary>

So P = (total + target) / 2. Count subsets with that sum.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

If (total + target) is odd or |target| > total, return 0. Otherwise count subsets summing to P with the 0/1 knapsack counting DP (downward loop).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int x : nums) total += x;
        if (Math.abs(target) > total || (total + target) % 2 != 0) return 0;
        int p = (total + target) / 2;
        int[] ways = new int[p + 1];
        ways[0] = 1;
        for (int x : nums) {
            for (int s = p; s >= x; s--) ways[s] += ways[s - x];   // each number once
        }
        return ways[p];
    }
}
```

</details>

## Complexity

- **Time:** O(n · P).
- **Space:** O(P).

## Common mistake

⚠️ Missing zeros: each 0 doubles the count — the DP handles it naturally if dp[0] starts at 1 and you loop down to x (including s = x = 0).

---

⬅️ [Previous: Partition Equal Subset Sum](./009-partition-equal-subset-sum.md) · [📋 Dynamic Programming list](./README.md) · [Next: Coin Change](./011-coin-change.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
