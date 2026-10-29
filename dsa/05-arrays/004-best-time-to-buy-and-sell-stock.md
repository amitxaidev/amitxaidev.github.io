# 4. Best Time to Buy and Sell Stock

**LeetCode 121** · 🟢 Easy · Pattern: **Running minimum**
🔗 Solve it here: [https://leetcode.com/problems/best-time-to-buy-and-sell-stock/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/004-best-time-to-buy-and-sell-stock.html](https://amitxaidev.github.io/dsa/05-arrays/004-best-time-to-buy-and-sell-stock.html)

## The problem, in short

prices[i] is a stock's price on day i. Buy on one day and sell on a later day for the biggest profit; return 0 if no profit is possible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For each selling day, the best buying day is the cheapest day before it.

</details>

<details>
<summary>💡 Hint 2</summary>

Track the minimum price seen so far as you scan.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass: keep the lowest price so far and the best profit of selling today. No need to look back at every earlier day.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);      // cheapest day so far
            best = Math.max(best, p - minPrice);   // sell today
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Taking max − min of the whole array; the max might come before the min.

---

⬅️ [Previous: Check if Array Is Sorted and Rotated](./003-check-if-array-is-sorted-and-rotated.md) · [📋 Arrays list](./README.md) · [Next: Find All Numbers Disappeared in an Array](./005-find-all-numbers-disappeared-in-an-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
