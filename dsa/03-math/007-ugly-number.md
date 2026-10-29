# 7. Ugly Number

**LeetCode 263** · 🟢 Easy · Pattern: **Prime factors**
🔗 Solve it here: [https://leetcode.com/problems/ugly-number/](https://leetcode.com/problems/ugly-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/007-ugly-number.html](https://amitxaidev.github.io/dsa/03-math/007-ugly-number.html)

## The problem, in short

An ugly number is a positive integer whose only prime factors are 2, 3 and 5. Decide whether n is ugly.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Non-positive numbers are never ugly.

</details>

<details>
<summary>💡 Hint 2</summary>

Divide out all 2s, then all 3s, then all 5s. What should be left?

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Repeatedly divide by 2, 3 and 5 while divisible. If what remains is 1, there were no other prime factors.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int p : new int[]{2, 3, 5}) {
            while (n % p == 0) n /= p;
        }
        return n == 1;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting n &lt;= 0; the while loop on 0 never ends because 0 % 2 == 0.

---

⬅️ [Previous: Greatest Common Divisor of Strings](./006-greatest-common-divisor-of-strings.md) · [📋 Basic Math list](./README.md) · [Next: Reverse Integer](./008-reverse-integer.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
