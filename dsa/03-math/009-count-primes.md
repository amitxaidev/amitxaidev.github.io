# 9. Count Primes

**LeetCode 204** · 🟡 Medium · Pattern: **Sieve of Eratosthenes**
🔗 Solve it here: [https://leetcode.com/problems/count-primes/](https://leetcode.com/problems/count-primes/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/009-count-primes.html](https://amitxaidev.github.io/dsa/03-math/009-count-primes.html)

## The problem, in short

Count the prime numbers strictly less than n.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Checking each number by trial division is too slow for n up to 5 million.

</details>

<details>
<summary>💡 Hint 2</summary>

Instead of testing numbers, cross out multiples of each prime.

</details>

<details>
<summary>💡 Hint 3</summary>

Start crossing out from p * p — smaller multiples were already crossed out by smaller primes.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sieve of Eratosthenes: a boolean array marks composites. For each p with p * p &lt; n that is still unmarked, mark p*p, p*p+p, … as composite. Count what remains unmarked from 2 to n-1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] composite = new boolean[n];
        for (int p = 2; (long) p * p < n; p++) {
            if (composite[p]) continue;
            for (int m = p * p; m < n; m += p) composite[m] = true;   // cross out multiples
        }
        int count = 0;
        for (int i = 2; i < n; i++) if (!composite[i]) count++;
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n log log n).
- **Space:** O(n).

## Common mistake

⚠️ Starting the inner loop at 2 * p (still correct, just slower) or using int for p * p, which can overflow — use p &lt;= n / p or a long.

---

⬅️ [Previous: Reverse Integer](./008-reverse-integer.md) · [📋 Basic Math list](./README.md) · [Next: Pow(x, n)](./010-powx-n.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
