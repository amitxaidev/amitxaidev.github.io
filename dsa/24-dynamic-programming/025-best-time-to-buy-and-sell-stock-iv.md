# 25. Best Time to Buy and Sell Stock IV

**LeetCode 188** · 🔴 Hard · Pattern: **State machine DP (k transactions)**
🔗 Solve it here: [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/025-best-time-to-buy-and-sell-stock-iv.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/025-best-time-to-buy-and-sell-stock-iv.html)

## The problem, in short

Make at most k buy-sell transactions. Return the maximum profit.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Generalise the two-transaction version with arrays buy[1..k] and sell[1..k].

</details>

<details>
<summary>💡 Hint 2</summary>

If k >= n / 2, there's effectively no limit — sum every rise.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each price and each j from 1 to k: buy[j] = max(buy[j], sell[j−1] − p), sell[j] = max(sell[j], buy[j] + p).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {                          // effectively unlimited
            int profit = 0;
            for (int i = 1; i < n; i++) profit += Math.max(0, prices[i] - prices[i - 1]);
            return profit;
        }
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int p : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - p);
                sell[j] = Math.max(sell[j], buy[j] + p);
            }
        }
        return sell[k];
    }
}
```

</details>

## Complexity

- **Time:** O(n·k).
- **Space:** O(k).

## Common mistake

⚠️ Huge k making the arrays and loops too big — handle k >= n/2 with the unlimited solution.

---

⬅️ [Previous: Best Time to Buy and Sell Stock III](./024-best-time-to-buy-and-sell-stock-iii.md) · [📋 Dynamic Programming list](./README.md) · [Next: Burst Balloons](./026-burst-balloons.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
