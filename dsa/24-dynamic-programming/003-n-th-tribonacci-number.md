# 3. N-th Tribonacci Number

**LeetCode 1137** · 🟢 Easy · Pattern: **1D DP**

## The problem, in short

T0 = 0, T1 = 1, T2 = 1 and each later term is the sum of the three before it. Return Tn.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/n-th-tribonacci-number/](https://leetcode.com/problems/n-th-tribonacci-number/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/003-n-th-tribonacci-number.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/003-n-th-tribonacci-number.html)

## Understanding

**Really asking:** each term is the sum of the previous three.

**Why this works:** keep the last three values and roll forward.

**Example:** 0, 1, 1, 2, 4, 7 → T5 = 7

## Hints

<details>
<summary>💡 Hint 1</summary>

Same idea as Fibonacci with three previous values.

</details>

<details>
<summary>💡 Hint 2</summary>

Memoised recursion and the iterative loop give the same O(n).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Roll three variables forward n − 2 times.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting the base cases for n = 0, 1 and 2.

---

⬅️ [Previous: Min Cost Climbing Stairs](./002-min-cost-climbing-stairs.md) · [📋 Dynamic Programming list](./README.md) · [Next: House Robber](./004-house-robber.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
