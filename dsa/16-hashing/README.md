# 16 · Hashing

HashMap and HashSet patterns: counting, grouping and prefix-sum maps.

📺 **Watch first:** Ep 37, Ep 38, Ep 39 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/16-hashing/  
🧮 **12 problems** · 🟢 6 Easy · 🟡 5 Medium · 🔴 1 Hard

## Understand the topic

A HashMap stores key → value pairs, and a HashSet stores keys, both with O(1) average lookup. Inside, the key's hashCode picks a bucket; collisions go into a chain (Java turns long chains into trees).

The common patterns are: "have I seen this before?" (a set), "how many of each?" (a count map), "where did I see it?" (a value → index map), and "group by a canonical key". Remember that arrays used as keys compare by reference, so convert them to a String or List first.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [1. Two Sum](./001-two-sum.md) | [Solve ↗](https://leetcode.com/problems/two-sum/) | 🟢 Easy | HashMap complement lookup | ⬜ |
| 2 | [217. Contains Duplicate](./002-contains-duplicate.md) | [Solve ↗](https://leetcode.com/problems/contains-duplicate/) | 🟢 Easy | HashSet | ⬜ |
| 3 | [349. Intersection of Two Arrays](./003-intersection-of-two-arrays.md) | [Solve ↗](https://leetcode.com/problems/intersection-of-two-arrays/) | 🟢 Easy | HashSet | ⬜ |
| 4 | [290. Word Pattern](./004-word-pattern.md) | [Solve ↗](https://leetcode.com/problems/word-pattern/) | 🟢 Easy | Two-way HashMap | ⬜ |
| 5 | [1207. Unique Number of Occurrences](./005-unique-number-of-occurrences.md) | [Solve ↗](https://leetcode.com/problems/unique-number-of-occurrences/) | 🟢 Easy | HashMap + HashSet | ⬜ |
| 6 | [202. Happy Number](./006-happy-number.md) | [Solve ↗](https://leetcode.com/problems/happy-number/) | 🟢 Easy | HashSet cycle detection | ⬜ |
| 7 | [128. Longest Consecutive Sequence](./007-longest-consecutive-sequence.md) | [Solve ↗](https://leetcode.com/problems/longest-consecutive-sequence/) | 🟡 Medium | HashSet, start only at run starts | ⬜ |
| 8 | [454. 4Sum II](./008-4sum-ii.md) | [Solve ↗](https://leetcode.com/problems/4sum-ii/) | 🟡 Medium | Meet in the middle with HashMap | ⬜ |
| 9 | [1679. Max Number of K-Sum Pairs](./009-max-number-of-k-sum-pairs.md) | [Solve ↗](https://leetcode.com/problems/max-number-of-k-sum-pairs/) | 🟡 Medium | HashMap pairing | ⬜ |
| 10 | [554. Brick Wall](./010-brick-wall.md) | [Solve ↗](https://leetcode.com/problems/brick-wall/) | 🟡 Medium | HashMap of edge positions | ⬜ |
| 11 | [2352. Equal Row and Column Pairs](./011-equal-row-and-column-pairs.md) | [Solve ↗](https://leetcode.com/problems/equal-row-and-column-pairs/) | 🟡 Medium | HashMap of row signatures | ⬜ |
| 12 | [149. Max Points on a Line](./012-max-points-on-a-line.md) | [Solve ↗](https://leetcode.com/problems/max-points-on-a-line/) | 🔴 Hard | HashMap of reduced slopes | ⬜ |

---

[🏠 Back to the DSA in Java course](../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
