# 26. Burst Balloons

**LeetCode 312** · 🔴 Hard · Pattern: **Interval DP (last to burst)**

## The problem, in short

Bursting balloon i earns nums[left] × nums[i] × nums[right], where left and right are its current neighbours (outside counts as 1). Return the maximum coins for bursting all balloons.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/burst-balloons/](https://leetcode.com/problems/burst-balloons/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/026-burst-balloons.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/026-burst-balloons.html)

## Understanding

**Really asking:** burst all balloons for the most coins.

**Why this works:** choose the LAST balloon to burst in a range; at that moment its neighbours are the range walls, so the left and right sides are independent.

**Example:** [3, 1, 5, 8] → padded [1,3,1,5,8,1]
```text
best order gives 167
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Choosing the first balloon to burst changes neighbours unpredictably. Choose the LAST balloon in a range instead.

</details>

<details>
<summary>💡 Hint 2</summary>

If k is the last balloon burst between walls l and r, its neighbours at that moment are exactly l and r.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Pad the array with 1 at both ends. dp[l][r] = best for balloons strictly between l and r = max over k of dp[l][k] + a[l]·a[k]·a[r] + dp[k][r]. Fill by increasing interval length.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] a = new int[n];
        a[0] = a[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) a[i + 1] = nums[i];
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int l = 0; l + len < n; l++) {
                int r = l + len;
                for (int k = l + 1; k < r; k++) {   // k is burst last between l and r
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + a[l] * a[k] * a[r] + dp[k][r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
```

</details>

## Complexity

- **Time:** O(n³).
- **Space:** O(n²).

## Common mistake

⚠️ Thinking about which balloon goes first — that state is not independent.

---

⬅️ [Previous: Best Time to Buy and Sell Stock IV](./025-best-time-to-buy-and-sell-stock-iv.md) · [📋 Dynamic Programming list](./README.md) · [Next: Minimum Cost to Cut a Stick](./027-minimum-cost-to-cut-a-stick.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
