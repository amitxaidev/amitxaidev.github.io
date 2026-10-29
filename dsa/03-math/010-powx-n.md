# 10. Pow(x, n)

**LeetCode 50** · 🟡 Medium · Pattern: **Fast exponentiation**

## The problem, in short

Compute x raised to an integer power n, where n can be negative and as large as 2^31 in size.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/powx-n/](https://leetcode.com/problems/powx-n/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/010-powx-n.html](https://amitxaidev.github.io/dsa/03-math/010-powx-n.html)

## Understanding

**Really asking:** x to the power n where n can be about ±2 billion.

**Why this works:** x^13 = x^8 · x^4 · x^1 (13 is 1101 in binary). Squaring x each step gives x, x², x⁴, x⁸; multiply in the ones whose bit is set. That's about 31 steps instead of 2 billion.

**Example:** x = 2, n = 10 (binary 1010)
```text
bit 0 = 0: base 2 → 4
bit 1 = 1: result 4,   base 16
bit 2 = 0: base 256
bit 3 = 1: result 4·256 = 1024
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Multiplying x by itself n times is O(n) — far too slow.

</details>

<details>
<summary>💡 Hint 2</summary>

x^n = (x^2)^(n/2) when n is even. Square the base and halve the exponent.

</details>

<details>
<summary>💡 Hint 3</summary>

Handle negative n with 1/x, and store n in a long because -Integer.MIN_VALUE overflows.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary exponentiation: while the exponent is positive, if its lowest bit is 1 multiply the answer by the base; then square the base and shift the exponent right. That's O(log n) multiplications.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public double myPow(double x, int n) {
        long e = n;            // long avoids overflow for Integer.MIN_VALUE
        if (e < 0) {
            x = 1 / x;
            e = -e;
        }
        double result = 1;
        while (e > 0) {
            if ((e & 1) == 1) result *= x;   // this bit of the exponent is set
            x *= x;
            e >>= 1;
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

⚠️ Writing n = -n with an int when n == Integer.MIN_VALUE — it stays negative.

---

⬅️ [Previous: Count Primes](./009-count-primes.md) · [📋 Basic Math list](./README.md) · [Next: Factorial Trailing Zeroes](./011-factorial-trailing-zeroes.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
