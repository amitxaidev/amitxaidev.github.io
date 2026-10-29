# 1. Climbing Stairs

**LeetCode 70** · 🟢 Easy · Pattern: **1D DP**
🔗 Solve it here: [https://leetcode.com/problems/climbing-stairs/](https://leetcode.com/problems/climbing-stairs/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/001-climbing-stairs.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/001-climbing-stairs.html)

## The problem, in short

You climb a staircase of n steps, taking 1 or 2 steps at a time. Count the distinct ways to reach the top.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

To stand on step i, your last move came from step i − 1 or step i − 2.

</details>

<details>
<summary>💡 Hint 2</summary>

ways(i) = ways(i − 1) + ways(i − 2) — Fibonacci again.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Define the state (ways to reach step i), the transition (sum of the two previous) and the base cases (ways(0) = ways(1) = 1). Only the last two values are needed.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int climbStairs(int n) {
        int prev = 1, cur = 1;   // ways(0), ways(1)
        for (int i = 2; i <= n; i++) {
            int next = prev + cur;
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Plain recursion without memoisation — exponential time.

---

[📋 Dynamic Programming list](./README.md) · [Next: Min Cost Climbing Stairs](./002-min-cost-climbing-stairs.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
