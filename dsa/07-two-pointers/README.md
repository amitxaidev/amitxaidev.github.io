# 07 · Two Pointers

Opposite ends, same direction, and merging — two indexes instead of nested loops.

📺 **Watch first:** Ep 9 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/07-two-pointers/  
🧮 **13 problems** · 🟢 6 Easy · 🟡 6 Medium · 🔴 1 Hard

## Understand the topic

Two pointers means using two indexes instead of a nested loop. It shows up in three shapes: pointers at both ends moving inward (sorted pairs, palindromes), a slow "write" pointer and a fast "read" pointer moving the same way (removing items in place), and one pointer per array (merging).

The key question every time: after looking at the two pointed values, which pointer can I safely move, and why can't I miss the answer by moving it?

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [26. Remove Duplicates from Sorted Array](./001-remove-duplicates-from-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | 🟢 Easy | Read/write pointers | ⬜ |
| 2 | [27. Remove Element](./002-remove-element.md) | [Solve ↗](https://leetcode.com/problems/remove-element/) | 🟢 Easy | Read/write pointers | ⬜ |
| 3 | [283. Move Zeroes](./003-move-zeroes.md) | [Solve ↗](https://leetcode.com/problems/move-zeroes/) | 🟢 Easy | Read/write pointers | ⬜ |
| 4 | [125. Valid Palindrome](./004-valid-palindrome.md) | [Solve ↗](https://leetcode.com/problems/valid-palindrome/) | 🟢 Easy | Opposite ends | ⬜ |
| 5 | [977. Squares of a Sorted Array](./005-squares-of-a-sorted-array.md) | [Solve ↗](https://leetcode.com/problems/squares-of-a-sorted-array/) | 🟢 Easy | Opposite ends, fill from back | ⬜ |
| 6 | [392. Is Subsequence](./006-is-subsequence.md) | [Solve ↗](https://leetcode.com/problems/is-subsequence/) | 🟢 Easy | Same direction | ⬜ |
| 7 | [167. Two Sum II - Input Array Is Sorted](./007-two-sum-ii-input-array-is-sorted.md) | [Solve ↗](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | 🟡 Medium | Opposite ends | ⬜ |
| 8 | [15. 3Sum](./008-3sum.md) | [Solve ↗](https://leetcode.com/problems/3sum/) | 🟡 Medium | Sort + two pointers | ⬜ |
| 9 | [18. 4Sum](./009-4sum.md) | [Solve ↗](https://leetcode.com/problems/4sum/) | 🟡 Medium | Sort + two pointers | ⬜ |
| 10 | [11. Container With Most Water](./010-container-with-most-water.md) | [Solve ↗](https://leetcode.com/problems/container-with-most-water/) | 🟡 Medium | Opposite ends, move the shorter | ⬜ |
| 11 | [80. Remove Duplicates from Sorted Array II](./011-remove-duplicates-from-sorted-array-ii.md) | [Solve ↗](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) | 🟡 Medium | Read/write pointers | ⬜ |
| 12 | [881. Boats to Save People](./012-boats-to-save-people.md) | [Solve ↗](https://leetcode.com/problems/boats-to-save-people/) | 🟡 Medium | Sort + opposite ends | ⬜ |
| 13 | [42. Trapping Rain Water](./013-trapping-rain-water.md) | [Solve ↗](https://leetcode.com/problems/trapping-rain-water/) | 🔴 Hard | Opposite ends with max heights | ⬜ |

---

[🏠 Back to the DSA in Java course](../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
