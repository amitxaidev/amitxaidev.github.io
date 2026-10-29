# 8. Reverse Integer

**LeetCode 7** · 🟡 Medium · Pattern: **Overflow checks**
🔗 Solve it here: [https://leetcode.com/problems/reverse-integer/](https://leetcode.com/problems/reverse-integer/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/008-reverse-integer.html](https://amitxaidev.github.io/dsa/03-math/008-reverse-integer.html)

## The problem, in short

Reverse the digits of a 32-bit signed integer. If the reversed value doesn't fit in 32 bits, return 0. You may not use 64-bit integers.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

x % 10 keeps the sign in Java, so negatives work without special handling.

</details>

<details>
<summary>💡 Hint 2</summary>

Before doing rev * 10 + d, check if that would go past Integer.MAX_VALUE or below Integer.MIN_VALUE.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Pop the last digit and push it onto rev. Before each push, compare rev with MAX_VALUE / 10 (and MIN_VALUE / 10). If it's already beyond, the next step overflows, so return 0.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int d = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && d > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && d < -8)) return 0;
            rev = rev * 10 + d;
        }
        return rev;
    }
}
```

</details>

## Complexity

- **Time:** O(log10 x).
- **Space:** O(1).

## Common mistake

⚠️ Checking for overflow after the multiplication — by then the value has already wrapped around.

---

⬅️ [Previous: Ugly Number](./007-ugly-number.md) · [📋 Basic Math list](./README.md) · [Next: Count Primes](./009-count-primes.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
