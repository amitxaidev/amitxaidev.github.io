# 18. Best Time to Buy and Sell Stock with Transaction Fee

**LeetCode 714** · 🟡 Medium · Pattern: **State machine DP**

## The problem, in short

Trade as often as you like (one share at a time), paying a fee on every sale. Maximise profit.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/018-best-time-to-buy-and-sell-stock-with-transaction-fee.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/018-best-time-to-buy-and-sell-stock-with-transaction-fee.html)

## Understanding

**Really asking:** unlimited trades with a fee per sale.

**Why this works:** two states: holding a share or holding cash; pay the fee when selling.

**Example:** [1, 3, 2, 8, 4, 9], fee 2
```text
buy 1 sell 8 (+5), buy 4 sell 9 (+3) → 8
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Two states per day: holding a share or not.

</details>

<details>
<summary>💡 Hint 2</summary>

cash = max(cash, hold + price − fee); hold = max(hold, cash − price).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Roll the two states through the days. Using the new cash when updating hold is safe here (it amounts to selling and rebuying on the same day, which never helps).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);   // sell (pay fee)
            hold = Math.max(hold, cash - prices[i]);         // buy
        }
        return cash;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Charging the fee on both buy and sell.

---

⬅️ [Previous: Best Time to Buy and Sell Stock with Cooldown](./017-best-time-to-buy-and-sell-stock-with-cooldown.md) · [📋 Dynamic Programming list](./README.md) · [Next: Word Break](./019-word-break.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
