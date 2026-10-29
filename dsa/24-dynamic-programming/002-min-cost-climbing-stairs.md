# 2. Min Cost Climbing Stairs

**LeetCode 746** · 🟢 Easy · Pattern: **1D DP**
🔗 Solve it here: [https://leetcode.com/problems/min-cost-climbing-stairs/](https://leetcode.com/problems/min-cost-climbing-stairs/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/002-min-cost-climbing-stairs.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/002-min-cost-climbing-stairs.html)

## The problem, in short

cost[i] is paid when you step on stair i, and you can then climb 1 or 2 stairs. You may start on stair 0 or 1. Return the minimum cost to get past the last stair.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Let dp[i] = minimum cost to stand on stair i (before paying it).

</details>

<details>
<summary>💡 Hint 2</summary>

dp[i] = min(dp[i − 1] + cost[i − 1], dp[i − 2] + cost[i − 2]).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dp[0] = dp[1] = 0. Fill up to dp[n], the top (one past the last stair). Two variables are enough.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;   // dp[i-2], dp[i-1]
        for (int i = 2; i <= cost.length; i++) {
            int c = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = c;
        }
        return b;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Returning dp[n − 1] — the top is past the last stair, index n.

---

⬅️ [Previous: Climbing Stairs](./001-climbing-stairs.md) · [📋 Dynamic Programming list](./README.md) · [Next: N-th Tribonacci Number](./003-n-th-tribonacci-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
