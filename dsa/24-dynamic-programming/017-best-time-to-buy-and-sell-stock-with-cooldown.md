# 17. Best Time to Buy and Sell Stock with Cooldown

**LeetCode 309** · 🟡 Medium · Pattern: **State machine DP**
🔗 Solve it here: [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/017-best-time-to-buy-and-sell-stock-with-cooldown.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/017-best-time-to-buy-and-sell-stock-with-cooldown.html)

## The problem, in short

Trade as many times as you like, holding at most one share, but after selling you must wait one day before buying again. Maximise profit.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track three states per day: holding a share, just sold (cooldown next), and resting (free to buy).

</details>

<details>
<summary>💡 Hint 2</summary>

hold = max(hold, rest − price); sold = hold + price; rest = max(rest, sold).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Update the three states each day using yesterday's values. The answer is max(sold, rest).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE / 2, sold = 0, rest = 0;
        for (int p : prices) {
            int prevSold = sold;
            sold = hold + p;                     // sell today
            hold = Math.max(hold, rest - p);     // buy only from rest (cooldown respected)
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Buying from yesterday's "sold" state — that skips the cooldown.

---

⬅️ [Previous: Edit Distance](./016-edit-distance.md) · [📋 Dynamic Programming list](./README.md) · [Next: Best Time to Buy and Sell Stock with Transaction Fee](./018-best-time-to-buy-and-sell-stock-with-transaction-fee.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
