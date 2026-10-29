# 2. Richest Customer Wealth

**LeetCode 1672** · 🟢 Easy · Pattern: **Nested loops**
🔗 Solve it here: [https://leetcode.com/problems/richest-customer-wealth/](https://leetcode.com/problems/richest-customer-wealth/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/002-richest-customer-wealth.html](https://amitxaidev.github.io/dsa/01-complexity/002-richest-customer-wealth.html)

## The problem, in short

A grid lists how much money each customer (row) has in each bank (column). A customer's wealth is the sum of their row. Return the largest wealth.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Sum each row, then keep the maximum of those sums.

</details>

<details>
<summary>💡 Hint 2</summary>

Two nested loops visit every cell exactly once. What is the Big O in terms of rows m and columns n?

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For every row add up the values and compare with the best so far. Every cell is touched once, so the cost is O(m·n) — nested loops are not automatically "O(n²)", they are the product of the two loop sizes.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maximumWealth(int[][] accounts) {
        int best = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int money : customer) {
                wealth += money;          // total of this row
            }
            best = Math.max(best, wealth);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n) where m = customers, n = banks.
- **Space:** O(1).

## Common mistake

⚠️ Calling nested loops "O(n²)" without thinking. Here it is rows × columns, which can be very different numbers.

---

⬅️ [Previous: Running Sum of 1d Array](./001-running-sum-of-1d-array.md) · [📋 Time & Space Complexity list](./README.md) · [Next: Find Numbers with Even Number of Digits](./003-find-numbers-with-even-number-of-digits.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
