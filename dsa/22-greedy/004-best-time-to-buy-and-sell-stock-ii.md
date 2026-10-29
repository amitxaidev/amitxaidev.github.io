# 4. Best Time to Buy and Sell Stock II

**LeetCode 122** · 🟡 Medium · Pattern: **Collect every rise**

## The problem, in short

You may buy and sell a stock many times (holding at most one share at a time). Return the maximum total profit.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/004-best-time-to-buy-and-sell-stock-ii.html](https://amitxaidev.github.io/dsa/22-greedy/004-best-time-to-buy-and-sell-stock-ii.html)

## Understanding

**Really asking:** many trades allowed; maximise profit.

**Why this works:** any profitable run equals the sum of its daily rises, so collect every rise.

**Example:** [7, 1, 5, 3, 6, 4]
```text
rises: 1→5 (+4), 3→6 (+3)
total 7
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Any profit over several days equals the sum of the daily increases in between.

</details>

<details>
<summary>💡 Hint 2</summary>

So take every day-to-day increase.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Add max(0, prices[i] − prices[i − 1]) for each i. This equals buying at every local low and selling at every local high.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];   // take every rise
        }
        return profit;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Looking for the single best buy/sell pair — that's the one-transaction problem.

---

⬅️ [Previous: Maximum Units on a Truck](./003-maximum-units-on-a-truck.md) · [📋 Greedy list](./README.md) · [Next: Jump Game](./005-jump-game.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
