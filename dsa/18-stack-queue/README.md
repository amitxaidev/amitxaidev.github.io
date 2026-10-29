# 18 · Stack & Queue

Parentheses, expression evaluation, monotonic stack and deque.

📺 **Watch first:** Ep 46, Ep 47, Ep 48, Ep 49, Ep 50, Ep 51, Ep 52 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/18-stack-queue/  
🧮 **18 problems** · 🟢 5 Easy · 🟡 9 Medium · 🔴 4 Hard

## Understand the topic

A stack is last-in, first-out, like a pile of plates. A queue is first-in, first-out, like a line at a counter. A deque lets you add and remove at both ends. In Java, use ArrayDeque for all three; Stack and LinkedList are older and slower.

The big pattern here is the monotonic stack: keep the stack increasing (or decreasing), and every pop answers "next greater" or "next smaller" for the popped item. Each item is pushed and popped once, so it's O(n).

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [20. Valid Parentheses](./001-valid-parentheses.md) | [Solve ↗](https://leetcode.com/problems/valid-parentheses/) | 🟢 Easy | Stack matching | ⬜ |
| 2 | [232. Implement Queue using Stacks](./002-implement-queue-using-stacks.md) | [Solve ↗](https://leetcode.com/problems/implement-queue-using-stacks/) | 🟢 Easy | Two stacks | ⬜ |
| 3 | [225. Implement Stack using Queues](./003-implement-stack-using-queues.md) | [Solve ↗](https://leetcode.com/problems/implement-stack-using-queues/) | 🟢 Easy | Rotate on push | ⬜ |
| 4 | [496. Next Greater Element I](./004-next-greater-element-i.md) | [Solve ↗](https://leetcode.com/problems/next-greater-element-i/) | 🟢 Easy | Monotonic stack | ⬜ |
| 5 | [844. Backspace String Compare](./005-backspace-string-compare.md) | [Solve ↗](https://leetcode.com/problems/backspace-string-compare/) | 🟢 Easy | Stack / backwards scan | ⬜ |
| 6 | [155. Min Stack](./006-min-stack.md) | [Solve ↗](https://leetcode.com/problems/min-stack/) | 🟡 Medium | Stack of (value, min) pairs | ⬜ |
| 7 | [150. Evaluate Reverse Polish Notation](./007-evaluate-reverse-polish-notation.md) | [Solve ↗](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | 🟡 Medium | Operand stack | ⬜ |
| 8 | [739. Daily Temperatures](./008-daily-temperatures.md) | [Solve ↗](https://leetcode.com/problems/daily-temperatures/) | 🟡 Medium | Monotonic stack of indexes | ⬜ |
| 9 | [503. Next Greater Element II](./009-next-greater-element-ii.md) | [Solve ↗](https://leetcode.com/problems/next-greater-element-ii/) | 🟡 Medium | Monotonic stack, circular | ⬜ |
| 10 | [901. Online Stock Span](./010-online-stock-span.md) | [Solve ↗](https://leetcode.com/problems/online-stock-span/) | 🟡 Medium | Monotonic stack with spans | ⬜ |
| 11 | [735. Asteroid Collision](./011-asteroid-collision.md) | [Solve ↗](https://leetcode.com/problems/asteroid-collision/) | 🟡 Medium | Stack simulation | ⬜ |
| 12 | [402. Remove K Digits](./012-remove-k-digits.md) | [Solve ↗](https://leetcode.com/problems/remove-k-digits/) | 🟡 Medium | Monotonic increasing stack | ⬜ |
| 13 | [907. Sum of Subarray Minimums](./013-sum-of-subarray-minimums.md) | [Solve ↗](https://leetcode.com/problems/sum-of-subarray-minimums/) | 🟡 Medium | Monotonic stack contribution | ⬜ |
| 14 | [622. Design Circular Queue](./014-design-circular-queue.md) | [Solve ↗](https://leetcode.com/problems/design-circular-queue/) | 🟡 Medium | Array ring buffer | ⬜ |
| 15 | [84. Largest Rectangle in Histogram](./015-largest-rectangle-in-histogram.md) | [Solve ↗](https://leetcode.com/problems/largest-rectangle-in-histogram/) | 🔴 Hard | Monotonic stack | ⬜ |
| 16 | [85. Maximal Rectangle](./016-maximal-rectangle.md) | [Solve ↗](https://leetcode.com/problems/maximal-rectangle/) | 🔴 Hard | Histogram per row | ⬜ |
| 17 | [239. Sliding Window Maximum](./017-sliding-window-maximum.md) | [Solve ↗](https://leetcode.com/problems/sliding-window-maximum/) | 🔴 Hard | Monotonic deque | ⬜ |
| 18 | [224. Basic Calculator](./018-basic-calculator.md) | [Solve ↗](https://leetcode.com/problems/basic-calculator/) | 🔴 Hard | Stack for parentheses and signs | ⬜ |

---

[🏠 Back to the DSA in Java course](../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
