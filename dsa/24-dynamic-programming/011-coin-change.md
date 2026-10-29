# 11. Coin Change

**LeetCode 322** · 🟡 Medium · Pattern: **Unbounded knapsack (min coins)**

## The problem, in short

Return the fewest coins needed to make an amount using unlimited coins of given denominations, or -1 if impossible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/coin-change/](https://leetcode.com/problems/coin-change/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/011-coin-change.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/011-coin-change.html)

## Understanding

**Really asking:** fewest coins to make an amount.

**Why this works:** dp[a] = 1 + min over coins of dp[a - coin]. Greedy can fail; DP tries every last coin.

**Example:** coins [1, 2, 5], amount 11
```text
dp[11] = dp[6] + 1 = (dp[1] + 1) + 1 = 3 (5 + 5 + 1)
```

## Hints

<details>
<summary>💡 Hint 1</summary>

dp[a] = fewest coins for amount a.

</details>

<details>
<summary>💡 Hint 2</summary>

dp[a] = 1 + min over coins c of dp[a − c].

</details>

<details>
<summary>💡 Hint 3</summary>

Greedy (largest coin first) fails, e.g. coins {1, 3, 4} and amount 6.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill dp from 1 to amount with "infinity" (amount + 1) as the start value. Each coin may be reused, so loop amounts upwards.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);   // safe "infinity"
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a) dp[a] = Math.min(dp[a], dp[a - c] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

</details>

## Complexity

- **Time:** O(amount · coins).
- **Space:** O(amount).

## Common mistake

⚠️ Using Integer.MAX_VALUE as infinity and then adding 1 — it overflows to negative.

---

⬅️ [Previous: Target Sum](./010-target-sum.md) · [📋 Dynamic Programming list](./README.md) · [Next: Coin Change II](./012-coin-change-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
