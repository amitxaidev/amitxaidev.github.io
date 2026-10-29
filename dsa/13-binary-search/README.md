# 13 · Binary Search

Lower/upper bound, rotated arrays and binary search on the answer.

📺 **Watch first:** Ep 21, Ep 22, Ep 23 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/13-binary-search/  
🧮 **17 problems** · 🟢 5 Easy · 🟡 10 Medium · 🔴 2 Hard

## Understand the topic

Binary search cuts the search space in half each step, so a million items take about 20 steps. It doesn't really need a sorted array; it needs a yes/no question whose answers look like F F F T T T. Then you find the first T.

There are two flavours. First, searching an array (lower bound, rotated arrays, peaks). Second, "binary search on the answer": guess a value like a speed or a capacity, check whether it's feasible, and move the guess.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [704. Binary Search](./001-binary-search.md) | [Solve ↗](https://leetcode.com/problems/binary-search/) | 🟢 Easy | Classic binary search | ⬜ |
| 2 | [35. Search Insert Position](./002-search-insert-position.md) | [Solve ↗](https://leetcode.com/problems/search-insert-position/) | 🟢 Easy | Lower bound | ⬜ |
| 3 | [69. Sqrt(x)](./003-sqrtx.md) | [Solve ↗](https://leetcode.com/problems/sqrtx/) | 🟢 Easy | Binary search on the answer | ⬜ |
| 4 | [278. First Bad Version](./004-first-bad-version.md) | [Solve ↗](https://leetcode.com/problems/first-bad-version/) | 🟢 Easy | First true | ⬜ |
| 5 | [1539. Kth Missing Positive Number](./005-kth-missing-positive-number.md) | [Solve ↗](https://leetcode.com/problems/kth-missing-positive-number/) | 🟢 Easy | Binary search on a derived value | ⬜ |
| 6 | [34. Find First and Last Position of Element in Sorted Array](./006-find-first-and-last-position-of-element-in-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | 🟡 Medium | Lower & upper bound | ⬜ |
| 7 | [33. Search in Rotated Sorted Array](./007-search-in-rotated-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/search-in-rotated-sorted-array/) | 🟡 Medium | Find the sorted half | ⬜ |
| 8 | [153. Find Minimum in Rotated Sorted Array](./008-find-minimum-in-rotated-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | 🟡 Medium | Compare with the right end | ⬜ |
| 9 | [162. Find Peak Element](./009-find-peak-element.md) | [Solve ↗](https://leetcode.com/problems/find-peak-element/) | 🟡 Medium | Follow the slope | ⬜ |
| 10 | [540. Single Element in a Sorted Array](./010-single-element-in-a-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/single-element-in-a-sorted-array/) | 🟡 Medium | Pair parity | ⬜ |
| 11 | [875. Koko Eating Bananas](./011-koko-eating-bananas.md) | [Solve ↗](https://leetcode.com/problems/koko-eating-bananas/) | 🟡 Medium | Binary search on the answer | ⬜ |
| 12 | [1011. Capacity To Ship Packages Within D Days](./012-capacity-to-ship-packages-within-d-days.md) | [Solve ↗](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | 🟡 Medium | Binary search on the answer | ⬜ |
| 13 | [1482. Minimum Number of Days to Make m Bouquets](./013-minimum-number-of-days-to-make-m-bouquets.md) | [Solve ↗](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/) | 🟡 Medium | Binary search on the answer | ⬜ |
| 14 | [1283. Find the Smallest Divisor Given a Threshold](./014-find-the-smallest-divisor-given-a-threshold.md) | [Solve ↗](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/) | 🟡 Medium | Binary search on the answer | ⬜ |
| 15 | [1552. Magnetic Force Between Two Balls](./015-magnetic-force-between-two-balls.md) | [Solve ↗](https://leetcode.com/problems/magnetic-force-between-two-balls/) | 🟡 Medium | Binary search on the answer (aggressive cows) | ⬜ |
| 16 | [410. Split Array Largest Sum](./016-split-array-largest-sum.md) | [Solve ↗](https://leetcode.com/problems/split-array-largest-sum/) | 🔴 Hard | Binary search on the answer (book allocation) | ⬜ |
| 17 | [4. Median of Two Sorted Arrays](./017-median-of-two-sorted-arrays.md) | [Solve ↗](https://leetcode.com/problems/median-of-two-sorted-arrays/) | 🔴 Hard | Binary search on the partition | ⬜ |

---

[🏠 Back to the full roadmap](../../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
