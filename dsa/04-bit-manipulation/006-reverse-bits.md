# 6. Reverse Bits

**LeetCode 190** · 🟢 Easy · Pattern: **Shifts**
🔗 Solve it here: [https://leetcode.com/problems/reverse-bits/](https://leetcode.com/problems/reverse-bits/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/006-reverse-bits.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/006-reverse-bits.html)

## The problem, in short

Reverse the order of the 32 bits of an integer.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Build the result one bit at a time: shift the result left, then add the lowest bit of n.

</details>

<details>
<summary>💡 Hint 2</summary>

Use n >>>= 1 so the sign bit doesn't get copied.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Loop exactly 32 times. Each step moves the lowest bit of n into the lowest position of the result after shifting the result left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);   // append n's last bit
            n >>>= 1;                           // unsigned shift
        }
        return result;
    }
}
```

</details>

## Complexity

- **Time:** O(32) = O(1).
- **Space:** O(1).

## Common mistake

⚠️ Stopping when n becomes 0. Leading zeros still need to become trailing zeros, so always run all 32 steps.

---

⬅️ [Previous: Missing Number](./005-missing-number.md) · [📋 Bit Manipulation list](./README.md) · [Next: Hamming Distance](./007-hamming-distance.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
