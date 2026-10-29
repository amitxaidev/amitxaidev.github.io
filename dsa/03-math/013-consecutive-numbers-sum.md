# 13. Consecutive Numbers Sum

**LeetCode 829** · 🔴 Hard · Pattern: **Number theory**

## The problem, in short

Count the ways to write n as a sum of one or more consecutive positive integers.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/consecutive-numbers-sum/](https://leetcode.com/problems/consecutive-numbers-sum/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/013-consecutive-numbers-sum.html](https://amitxaidev.github.io/dsa/03-math/013-consecutive-numbers-sum.html)

## Understanding

**Really asking:** in how many ways is n a sum of a run of consecutive positive numbers?

**Why this works:** a run of length k starting at x sums to k·x + k(k-1)/2. For a fixed k, solve for x and check it's a positive whole number. k only goes up to about √(2n).

**Example:** n = 9
```text
k=1: 9 % 1 = 0 → [9]
k=2: (9-1) % 2 = 0 → [4,5]
k=3: (9-3) % 3 = 0 → [2,3,4]
k=4: (9-6) % 4 ≠ 0
answer: 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

A run of k numbers starting at x sums to k·x + k(k-1)/2.

</details>

<details>
<summary>💡 Hint 2</summary>

So for a fixed k, a valid x exists exactly when n - k(k-1)/2 is positive and divisible by k.

</details>

<details>
<summary>💡 Hint 3</summary>

k(k-1)/2 must stay below n, so k only goes up to about √(2n).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Try every length k from 1 while k(k-1)/2 &lt; n. For each, check whether (n - k(k-1)/2) % k == 0. Each success is one way.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int consecutiveNumbersSum(int n) {
        int ways = 0;
        for (long k = 1; k * (k - 1) / 2 < n; k++) {
            if ((n - k * (k - 1) / 2) % k == 0) ways++;   // a positive start x exists
        }
        return ways;
    }
}
```

</details>

## Complexity

- **Time:** O(√n).
- **Space:** O(1).

## Common mistake

⚠️ Looping x over all starting values — that's O(n) or worse and times out for n up to 10^9.

---

⬅️ [Previous: Count Good Numbers](./012-count-good-numbers.md) · [📋 Basic Math list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
