# 05 · Arrays

Traversal, in-place updates, rotation and the top array interview questions.

📺 **Watch first:** [Ep 7](https://youtu.be/4NdluWqUZ3c), Ep 15 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/05-arrays/  
🧮 **14 problems** · 🟢 7 Easy · 🟡 6 Medium · 🔴 1 Hard

## Understand the topic

An array is a row of numbered lockers: you can open any locker instantly by its number (O(1)), but inserting into the middle means shifting everyone after it (O(n)).

Most array problems are won by one of these moves: a single pass with a running value (max, min, count), using the values themselves as indexes (marking or "cyclic sort"), reversing parts of the array, or writing from the back so you don't overwrite data you still need.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [1920. Build Array from Permutation](./001-build-array-from-permutation.md) | [Solve ↗](https://leetcode.com/problems/build-array-from-permutation/) | 🟢 Easy | Index mapping | ⬜ |
| 2 | [485. Max Consecutive Ones](./002-max-consecutive-ones.md) | [Solve ↗](https://leetcode.com/problems/max-consecutive-ones/) | 🟢 Easy | Running counter | ⬜ |
| 3 | [1752. Check if Array Is Sorted and Rotated](./003-check-if-array-is-sorted-and-rotated.md) | [Solve ↗](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/) | 🟢 Easy | Count drops | ⬜ |
| 4 | [121. Best Time to Buy and Sell Stock](./004-best-time-to-buy-and-sell-stock.md) | [Solve ↗](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | 🟢 Easy | Running minimum | ⬜ |
| 5 | [448. Find All Numbers Disappeared in an Array](./005-find-all-numbers-disappeared-in-an-array.md) | [Solve ↗](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) | 🟢 Easy | Index marking | ⬜ |
| 6 | [66. Plus One](./006-plus-one.md) | [Solve ↗](https://leetcode.com/problems/plus-one/) | 🟢 Easy | Carry handling | ⬜ |
| 7 | [88. Merge Sorted Array](./007-merge-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/merge-sorted-array/) | 🟢 Easy | Merge from the back | ⬜ |
| 8 | [189. Rotate Array](./008-rotate-array.md) | [Solve ↗](https://leetcode.com/problems/rotate-array/) | 🟡 Medium | Reversal trick | ⬜ |
| 9 | [31. Next Permutation](./009-next-permutation.md) | [Solve ↗](https://leetcode.com/problems/next-permutation/) | 🟡 Medium | Pivot + reverse | ⬜ |
| 10 | [2149. Rearrange Array Elements by Sign](./010-rearrange-array-elements-by-sign.md) | [Solve ↗](https://leetcode.com/problems/rearrange-array-elements-by-sign/) | 🟡 Medium | Two write indexes | ⬜ |
| 11 | [442. Find All Duplicates in an Array](./011-find-all-duplicates-in-an-array.md) | [Solve ↗](https://leetcode.com/problems/find-all-duplicates-in-an-array/) | 🟡 Medium | Index marking | ⬜ |
| 12 | [287. Find the Duplicate Number](./012-find-the-duplicate-number.md) | [Solve ↗](https://leetcode.com/problems/find-the-duplicate-number/) | 🟡 Medium | Floyd's cycle on indexes | ⬜ |
| 13 | [274. H-Index](./013-h-index.md) | [Solve ↗](https://leetcode.com/problems/h-index/) | 🟡 Medium | Counting sort | ⬜ |
| 14 | [41. First Missing Positive](./014-first-missing-positive.md) | [Solve ↗](https://leetcode.com/problems/first-missing-positive/) | 🔴 Hard | Cyclic sort | ⬜ |

---

[🏠 Back to the full roadmap](../../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
