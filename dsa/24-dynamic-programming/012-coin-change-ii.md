# 12. Coin Change II

**LeetCode 518** · 🟡 Medium · Pattern: **Unbounded knapsack (count combinations)**

## The problem, in short

Count the combinations of coins (unlimited supply) that add up to amount. Order doesn't matter.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/coin-change-ii/](https://leetcode.com/problems/coin-change-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/012-coin-change-ii.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/012-coin-change-ii.html)

## Understanding

**Really asking:** how many combinations make the amount?

**Why this works:** loop coins outside, amounts inside, so each combination is counted once (order doesn't matter).

**Example:** amount 5, coins [1, 2, 5]
```text
5, 2+2+1, 2+1+1+1, 1×5 → 4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Loop over coins on the outside and amounts on the inside — that counts combinations, not orderings.

</details>

<details>
<summary>💡 Hint 2</summary>

ways[a] += ways[a − coin], with amounts going upwards (coins can repeat).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

ways[0] = 1. For each coin, for a from coin to amount, add ways[a − coin].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount + 1];
        ways[0] = 1;
        for (int c : coins) {                 // coins outside: combinations
            for (int a = c; a <= amount; a++) {
                ways[a] += ways[a - c];
            }
        }
        return ways[amount];
    }
}
```

</details>

## Complexity

- **Time:** O(amount · coins).
- **Space:** O(amount).

## Common mistake

⚠️ Swapping the loops, which counts 1+2 and 2+1 as different (that's a different problem).

---

⬅️ [Previous: Coin Change](./011-coin-change.md) · [📋 Dynamic Programming list](./README.md) · [Next: Longest Common Subsequence](./013-longest-common-subsequence.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
