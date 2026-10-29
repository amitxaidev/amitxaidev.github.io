# 11. Sum of Two Integers

**LeetCode 371** · 🟡 Medium · Pattern: **XOR + carry**
🔗 Solve it here: [https://leetcode.com/problems/sum-of-two-integers/](https://leetcode.com/problems/sum-of-two-integers/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/011-sum-of-two-integers.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/011-sum-of-two-integers.html)

## The problem, in short

Add two integers without using + or -.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

a ^ b adds bits without carrying.

</details>

<details>
<summary>💡 Hint 2</summary>

(a & b) &lt;&lt; 1 gives the carries.

</details>

<details>
<summary>💡 Hint 3</summary>

Repeat until there's no carry left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep replacing (a, b) with (a ^ b, (a & b) &lt;&lt; 1). The carry moves left each round and eventually becomes 0. Java's two's-complement ints make negative numbers work automatically.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;     // sum without carry
            b = carry;     // add the carry next round
        }
        return a;
    }
}
```

</details>

## Complexity

- **Time:** O(32) = O(1).
- **Space:** O(1).

## Common mistake

⚠️ Writing a while loop on b > 0 — the carry can be negative, so loop while b != 0.

---

⬅️ [Previous: Single Number III](./010-single-number-iii.md) · [📋 Bit Manipulation list](./README.md) · [Next: Bitwise AND of Numbers Range](./012-bitwise-and-of-numbers-range.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
