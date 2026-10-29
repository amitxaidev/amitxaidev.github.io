# 8. Complement of Base 10 Integer

**LeetCode 1009** · 🟢 Easy · Pattern: **Bit masks**
🔗 Solve it here: [https://leetcode.com/problems/complement-of-base-10-integer/](https://leetcode.com/problems/complement-of-base-10-integer/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/008-complement-of-base-10-integer.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/008-complement-of-base-10-integer.html)

## The problem, in short

Flip every bit of n's binary form (only the bits that are actually used, no leading zeros) and return the result. For example 5 = 101 becomes 010 = 2.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

~n flips all 32 bits, including the leading zeros — too many.

</details>

<details>
<summary>💡 Hint 2</summary>

Build a mask of 1s as long as n's binary form, then XOR.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Grow mask = 1, 11, 111, … until it covers n, then return n ^ mask. Watch the special case n = 0, whose complement is 1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = 0;
        while (mask < n) mask = (mask << 1) | 1;   // 1, 11, 111, ...
        return n ^ mask;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Returning ~n, which gives a negative number.

---

⬅️ [Previous: Hamming Distance](./007-hamming-distance.md) · [📋 Bit Manipulation list](./README.md) · [Next: Single Number II](./009-single-number-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
