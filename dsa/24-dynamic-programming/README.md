# 24 · Dynamic Programming

1D, grid, knapsack, subsequences, strings, stocks, partition, trees and bitmask DP.

📺 **Watch first:** Ep 86, Ep 87, Ep 88, Ep 89, Ep 90, Ep 91, Ep 92, Ep 93, Ep 94, Ep 95, Ep 96 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/24-dynamic-programming/  
🧮 **28 problems** · 🟢 3 Easy · 🟡 18 Medium · 🔴 7 Hard

## Understand the topic

Dynamic programming is recursion that remembers. When a problem breaks into smaller sub-problems that repeat, solve each one once and store the result: top-down with memoisation, or bottom-up with a table.

Every DP answer needs four things. The state: what does dp[i] (or dp[i][j]) mean in plain words? The transition: how is it built from smaller states? The base cases. And the fill order. Write the state in a comment before you code. The families here are 1D, grid, 0/1 and unbounded knapsack, subsequences (LCS, LIS), strings (edit distance), stock state machines, partition/interval DP, trees and bitmasks.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [70. Climbing Stairs](./001-climbing-stairs.md) | [Solve ↗](https://leetcode.com/problems/climbing-stairs/) | 🟢 Easy | 1D DP | ⬜ |
| 2 | [746. Min Cost Climbing Stairs](./002-min-cost-climbing-stairs.md) | [Solve ↗](https://leetcode.com/problems/min-cost-climbing-stairs/) | 🟢 Easy | 1D DP | ⬜ |
| 3 | [1137. N-th Tribonacci Number](./003-n-th-tribonacci-number.md) | [Solve ↗](https://leetcode.com/problems/n-th-tribonacci-number/) | 🟢 Easy | 1D DP | ⬜ |
| 4 | [198. House Robber](./004-house-robber.md) | [Solve ↗](https://leetcode.com/problems/house-robber/) | 🟡 Medium | 1D DP (take / skip) | ⬜ |
| 5 | [213. House Robber II](./005-house-robber-ii.md) | [Solve ↗](https://leetcode.com/problems/house-robber-ii/) | 🟡 Medium | 1D DP on two ranges | ⬜ |
| 6 | [62. Unique Paths](./006-unique-paths.md) | [Solve ↗](https://leetcode.com/problems/unique-paths/) | 🟡 Medium | 2D grid DP | ⬜ |
| 7 | [64. Minimum Path Sum](./007-minimum-path-sum.md) | [Solve ↗](https://leetcode.com/problems/minimum-path-sum/) | 🟡 Medium | 2D grid DP | ⬜ |
| 8 | [120. Triangle](./008-triangle.md) | [Solve ↗](https://leetcode.com/problems/triangle/) | 🟡 Medium | Bottom-up DP | ⬜ |
| 9 | [416. Partition Equal Subset Sum](./009-partition-equal-subset-sum.md) | [Solve ↗](https://leetcode.com/problems/partition-equal-subset-sum/) | 🟡 Medium | 0/1 knapsack (subset sum) | ⬜ |
| 10 | [494. Target Sum](./010-target-sum.md) | [Solve ↗](https://leetcode.com/problems/target-sum/) | 🟡 Medium | 0/1 knapsack (count subsets) | ⬜ |
| 11 | [322. Coin Change](./011-coin-change.md) | [Solve ↗](https://leetcode.com/problems/coin-change/) | 🟡 Medium | Unbounded knapsack (min coins) | ⬜ |
| 12 | [518. Coin Change II](./012-coin-change-ii.md) | [Solve ↗](https://leetcode.com/problems/coin-change-ii/) | 🟡 Medium | Unbounded knapsack (count combinations) | ⬜ |
| 13 | [1143. Longest Common Subsequence](./013-longest-common-subsequence.md) | [Solve ↗](https://leetcode.com/problems/longest-common-subsequence/) | 🟡 Medium | 2D DP on two strings | ⬜ |
| 14 | [300. Longest Increasing Subsequence](./014-longest-increasing-subsequence.md) | [Solve ↗](https://leetcode.com/problems/longest-increasing-subsequence/) | 🟡 Medium | Patience sorting + binary search | ⬜ |
| 15 | [516. Longest Palindromic Subsequence](./015-longest-palindromic-subsequence.md) | [Solve ↗](https://leetcode.com/problems/longest-palindromic-subsequence/) | 🟡 Medium | Interval DP | ⬜ |
| 16 | [72. Edit Distance](./016-edit-distance.md) | [Solve ↗](https://leetcode.com/problems/edit-distance/) | 🟡 Medium | 2D DP on two strings | ⬜ |
| 17 | [309. Best Time to Buy and Sell Stock with Cooldown](./017-best-time-to-buy-and-sell-stock-with-cooldown.md) | [Solve ↗](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | 🟡 Medium | State machine DP | ⬜ |
| 18 | [714. Best Time to Buy and Sell Stock with Transaction Fee](./018-best-time-to-buy-and-sell-stock-with-transaction-fee.md) | [Solve ↗](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | 🟡 Medium | State machine DP | ⬜ |
| 19 | [139. Word Break](./019-word-break.md) | [Solve ↗](https://leetcode.com/problems/word-break/) | 🟡 Medium | Prefix DP | ⬜ |
| 20 | [337. House Robber III](./020-house-robber-iii.md) | [Solve ↗](https://leetcode.com/problems/house-robber-iii/) | 🟡 Medium | DP on trees | ⬜ |
| 21 | [526. Beautiful Arrangement](./021-beautiful-arrangement.md) | [Solve ↗](https://leetcode.com/problems/beautiful-arrangement/) | 🟡 Medium | Bitmask DP | ⬜ |
| 22 | [115. Distinct Subsequences](./022-distinct-subsequences.md) | [Solve ↗](https://leetcode.com/problems/distinct-subsequences/) | 🔴 Hard | 2D DP counting | ⬜ |
| 23 | [44. Wildcard Matching](./023-wildcard-matching.md) | [Solve ↗](https://leetcode.com/problems/wildcard-matching/) | 🔴 Hard | 2D DP on string and pattern | ⬜ |
| 24 | [123. Best Time to Buy and Sell Stock III](./024-best-time-to-buy-and-sell-stock-iii.md) | [Solve ↗](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | 🔴 Hard | State machine DP (2 transactions) | ⬜ |
| 25 | [188. Best Time to Buy and Sell Stock IV](./025-best-time-to-buy-and-sell-stock-iv.md) | [Solve ↗](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | 🔴 Hard | State machine DP (k transactions) | ⬜ |
| 26 | [312. Burst Balloons](./026-burst-balloons.md) | [Solve ↗](https://leetcode.com/problems/burst-balloons/) | 🔴 Hard | Interval DP (last to burst) | ⬜ |
| 27 | [1547. Minimum Cost to Cut a Stick](./027-minimum-cost-to-cut-a-stick.md) | [Solve ↗](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/) | 🔴 Hard | Partition DP (MCM style) | ⬜ |
| 28 | [847. Shortest Path Visiting All Nodes](./028-shortest-path-visiting-all-nodes.md) | [Solve ↗](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) | 🔴 Hard | BFS over (node, visited-mask) | ⬜ |

---

[🏠 Back to the full roadmap](../../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
