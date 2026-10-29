# 26 · Segment Tree, Fenwick & Sparse Table

Range queries with point updates.

📺 **Watch first:** Ep 98, Ep 99, Ep 100 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/26-segment-fenwick/  
🧮 **6 problems** · 🟢 0 Easy · 🟡 2 Medium · 🔴 4 Hard

## Understand the topic

A prefix sum makes range queries fast, but then every update costs O(n). These structures make both queries and updates O(log n).

A Fenwick tree (Binary Indexed Tree) stores partial sums in an array; i & -i decides how far each step jumps, and it's perfect for prefix sums and counts. A segment tree stores the answer for every range in a binary tree; it handles sum, min and max, and with lazy propagation also range updates. A sparse table answers static range-minimum queries in O(1) after O(n log n) preprocessing.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [307. Range Sum Query - Mutable](./001-range-sum-query-mutable.md) | [Solve ↗](https://leetcode.com/problems/range-sum-query-mutable/) | 🟡 Medium | Fenwick tree (BIT) | ⬜ |
| 2 | [729. My Calendar I](./002-my-calendar-i.md) | [Solve ↗](https://leetcode.com/problems/my-calendar-i/) | 🟡 Medium | Ordered map (floor / ceiling) | ⬜ |
| 3 | [327. Count of Range Sum](./003-count-of-range-sum.md) | [Solve ↗](https://leetcode.com/problems/count-of-range-sum/) | 🔴 Hard | Fenwick tree over compressed prefix sums | ⬜ |
| 4 | [1649. Create Sorted Array through Instructions](./004-create-sorted-array-through-instructions.md) | [Solve ↗](https://leetcode.com/problems/create-sorted-array-through-instructions/) | 🔴 Hard | Fenwick tree counting | ⬜ |
| 5 | [699. Falling Squares](./005-falling-squares.md) | [Solve ↗](https://leetcode.com/problems/falling-squares/) | 🔴 Hard | Segment tree with range assign / range max | ⬜ |
| 6 | [2407. Longest Increasing Subsequence II](./006-longest-increasing-subsequence-ii.md) | [Solve ↗](https://leetcode.com/problems/longest-increasing-subsequence-ii/) | 🔴 Hard | Segment tree over values (range max) | ⬜ |

---

[🏠 Back to the full roadmap](../../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
