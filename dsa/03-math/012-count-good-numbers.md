# 12. Count Good Numbers

**LeetCode 1922** · 🟡 Medium · Pattern: **Modular exponentiation**
🔗 Solve it here: [https://leetcode.com/problems/count-good-numbers/](https://leetcode.com/problems/count-good-numbers/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/012-count-good-numbers.html](https://amitxaidev.github.io/dsa/03-math/012-count-good-numbers.html)

## The problem, in short

A digit string is "good" if digits at even indexes are even (0,2,4,6,8) and digits at odd indexes are prime (2,3,5,7). Count good strings of length n, modulo 1e9+7. n can be up to 10^15.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Even positions have 5 choices, odd positions have 4.

</details>

<details>
<summary>💡 Hint 2</summary>

There are (n + 1) / 2 even positions and n / 2 odd positions.

</details>

<details>
<summary>💡 Hint 3</summary>

The answer is 5^a × 4^b mod M — use fast power with long.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count the positions, then compute both powers with modular binary exponentiation and multiply them under the modulus.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2, odd = n / 2;
        return (int) (pow(5, even) * pow(4, odd) % MOD);
    }

    private long pow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Taking the modulus only at the end. Every multiplication must be reduced, or a long overflows.

---

⬅️ [Previous: Factorial Trailing Zeroes](./011-factorial-trailing-zeroes.md) · [📋 Basic Math list](./README.md) · [Next: Consecutive Numbers Sum](./013-consecutive-numbers-sum.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
