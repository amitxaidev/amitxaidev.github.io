# 09 · Kadane, Dutch Flag & Moore's Voting

Three famous one-pass array algorithms and their variations.

📺 **Watch first:** Ep 11, Ep 12, Ep 13 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/  
🧮 **9 problems** · 🟢 2 Easy · 🟡 7 Medium · 🔴 0 Hard

## Understand the topic

Three classic one-pass algorithms. Kadane's algorithm finds the best subarray sum by deciding at each step: extend the current run, or start fresh? The Dutch National Flag sorts 0s, 1s and 2s in one pass with three pointers (low, mid, high). Moore's voting finds the majority element by letting different votes cancel each other out.

They all run in O(n) time with O(1) extra space, which is why interviewers love them.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [169. Majority Element](./001-majority-element.md) | [Solve ↗](https://leetcode.com/problems/majority-element/) | 🟢 Easy | Moore's voting | ⬜ |
| 2 | [905. Sort Array By Parity](./002-sort-array-by-parity.md) | [Solve ↗](https://leetcode.com/problems/sort-array-by-parity/) | 🟢 Easy | Two-way partition | ⬜ |
| 3 | [53. Maximum Subarray](./003-maximum-subarray.md) | [Solve ↗](https://leetcode.com/problems/maximum-subarray/) | 🟡 Medium | Kadane | ⬜ |
| 4 | [152. Maximum Product Subarray](./004-maximum-product-subarray.md) | [Solve ↗](https://leetcode.com/problems/maximum-product-subarray/) | 🟡 Medium | Kadane with min & max | ⬜ |
| 5 | [918. Maximum Sum Circular Subarray](./005-maximum-sum-circular-subarray.md) | [Solve ↗](https://leetcode.com/problems/maximum-sum-circular-subarray/) | 🟡 Medium | Kadane max & min | ⬜ |
| 6 | [1749. Maximum Absolute Sum of Any Subarray](./006-maximum-absolute-sum-of-any-subarray.md) | [Solve ↗](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/) | 🟡 Medium | Kadane max & min | ⬜ |
| 7 | [75. Sort Colors](./007-sort-colors.md) | [Solve ↗](https://leetcode.com/problems/sort-colors/) | 🟡 Medium | Dutch National Flag | ⬜ |
| 8 | [229. Majority Element II](./008-majority-element-ii.md) | [Solve ↗](https://leetcode.com/problems/majority-element-ii/) | 🟡 Medium | Extended Moore's voting | ⬜ |
| 9 | [1186. Maximum Subarray Sum with One Deletion](./009-maximum-subarray-sum-with-one-deletion.md) | [Solve ↗](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/) | 🟡 Medium | Kadane with two states | ⬜ |

---

[🏠 Back to the DSA in Java course](../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
