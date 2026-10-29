# 24. Best Time to Buy and Sell Stock III

**LeetCode 123** · 🔴 Hard · Pattern: **State machine DP (2 transactions)**
🔗 Solve it here: [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/024-best-time-to-buy-and-sell-stock-iii.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/024-best-time-to-buy-and-sell-stock-iii.html)

## The problem, in short

Make at most two buy-sell transactions (not overlapping). Return the maximum profit.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track four states: after first buy, after first sell, after second buy, after second sell.

</details>

<details>
<summary>💡 Hint 2</summary>

Each state builds on the previous one in the chain.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each price: buy1 = max(buy1, −p), sell1 = max(sell1, buy1 + p), buy2 = max(buy2, sell1 − p), sell2 = max(sell2, buy2 + p). Answer sell2.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int p : prices) {
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1, buy1 + p);
            buy2 = Math.max(buy2, sell1 - p);     // second buy uses first profit
            sell2 = Math.max(sell2, buy2 + p);
        }
        return sell2;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Splitting the array at every point and running the one-transaction solution on both sides each time — O(n²).

---

⬅️ [Previous: Wildcard Matching](./023-wildcard-matching.md) · [📋 Dynamic Programming list](./README.md) · [Next: Best Time to Buy and Sell Stock IV](./025-best-time-to-buy-and-sell-stock-iv.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
