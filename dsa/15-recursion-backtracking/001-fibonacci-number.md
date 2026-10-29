# 1. Fibonacci Number

**LeetCode 509** · 🟢 Easy · Pattern: **Recursion → iteration**
🔗 Solve it here: [https://leetcode.com/problems/fibonacci-number/](https://leetcode.com/problems/fibonacci-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/001-fibonacci-number.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/001-fibonacci-number.html)

## The problem, in short

Return the n-th Fibonacci number, where F(0) = 0, F(1) = 1 and each next number is the sum of the two before it.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The direct recursion F(n) = F(n−1) + F(n−2) recomputes the same values again and again: O(2^n).

</details>

<details>
<summary>💡 Hint 2</summary>

Draw the recursion tree for n = 5 and count how often F(2) appears.

</details>

<details>
<summary>💡 Hint 3</summary>

Keep only the last two values and loop.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Understand the recursive definition and its base cases first, then notice each value depends only on the previous two. Roll two variables forward n times.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int fib(int n) {
        if (n < 2) return n;          // base cases F(0)=0, F(1)=1
        int prev = 0, cur = 1;
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

⚠️ Missing a base case — the recursion never stops (StackOverflowError).

---

[📋 Recursion & Backtracking list](./README.md) · [Next: Sum of All Subset XOR Totals](./002-sum-of-all-subset-xor-totals.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
