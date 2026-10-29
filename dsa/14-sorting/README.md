# 14 · Sorting

Merge sort, quick sort, counting/bucket sort and custom comparators.

📺 **Watch first:** Ep 24, Ep 25, Ep 26, Ep 27, Ep 28 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/14-sorting/  
🧮 **11 problems** · 🟢 3 Easy · 🟡 6 Medium · 🔴 2 Hard

## Understand the topic

Sorting puts order into data so that later steps become easy. Merge sort splits in half, sorts both halves and merges them, always O(n log n). Quick sort partitions around a pivot. Counting and bucket sort beat n log n when values come from a small range.

In Java, Arrays.sort(int[]) sorts primitives, while Arrays.sort(T[], comparator) and list.sort(...) take a custom order. Many hard problems are "merge sort plus counting while you merge".

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [1051. Height Checker](./001-height-checker.md) | [Solve ↗](https://leetcode.com/problems/height-checker/) | 🟢 Easy | Counting sort | ⬜ |
| 2 | [1636. Sort Array by Increasing Frequency](./002-sort-array-by-increasing-frequency.md) | [Solve ↗](https://leetcode.com/problems/sort-array-by-increasing-frequency/) | 🟢 Easy | Custom comparator | ⬜ |
| 3 | [1122. Relative Sort Array](./003-relative-sort-array.md) | [Solve ↗](https://leetcode.com/problems/relative-sort-array/) | 🟢 Easy | Counting sort | ⬜ |
| 4 | [912. Sort an Array](./004-sort-an-array.md) | [Solve ↗](https://leetcode.com/problems/sort-an-array/) | 🟡 Medium | Merge sort | ⬜ |
| 5 | [148. Sort List](./005-sort-list.md) | [Solve ↗](https://leetcode.com/problems/sort-list/) | 🟡 Medium | Merge sort on a linked list | ⬜ |
| 6 | [179. Largest Number](./006-largest-number.md) | [Solve ↗](https://leetcode.com/problems/largest-number/) | 🟡 Medium | Comparator on concatenation | ⬜ |
| 7 | [56. Merge Intervals](./007-merge-intervals.md) | [Solve ↗](https://leetcode.com/problems/merge-intervals/) | 🟡 Medium | Sort by start | ⬜ |
| 8 | [791. Custom Sort String](./008-custom-sort-string.md) | [Solve ↗](https://leetcode.com/problems/custom-sort-string/) | 🟡 Medium | Counting by custom order | ⬜ |
| 9 | [164. Maximum Gap](./009-maximum-gap.md) | [Solve ↗](https://leetcode.com/problems/maximum-gap/) | 🟡 Medium | Bucket sort (pigeonhole) | ⬜ |
| 10 | [315. Count of Smaller Numbers After Self](./010-count-of-smaller-numbers-after-self.md) | [Solve ↗](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | 🔴 Hard | Merge sort with indexes | ⬜ |
| 11 | [493. Reverse Pairs](./011-reverse-pairs.md) | [Solve ↗](https://leetcode.com/problems/reverse-pairs/) | 🔴 Hard | Merge sort counting | ⬜ |

---

[🏠 Back to the DSA in Java course](../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
