# 7. Hamming Distance

**LeetCode 461** · 🟢 Easy · Pattern: **XOR + popcount**

## The problem, in short

Count the bit positions where two integers differ.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/hamming-distance/](https://leetcode.com/problems/hamming-distance/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/007-hamming-distance.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/007-hamming-distance.html)

## Understanding

**Really asking:** in how many positions do the two numbers' bits differ?

**Why this works:** XOR leaves a 1 exactly where they differ; count those.

**Example:** x = 1 (0001), y = 4 (0100)
```text
0001 ^ 0100 = 0101 → two 1s → 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

XOR has a 1 exactly where the bits differ.

</details>

<details>
<summary>💡 Hint 2</summary>

Then count the 1-bits of the XOR.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Compute x ^ y and count its set bits with the n & (n - 1) trick (or Integer.bitCount).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y, count = 0;
        while (diff != 0) {
            diff &= diff - 1;
            count++;
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(1).
- **Space:** O(1).

## Common mistake

⚠️ Comparing decimal digits instead of bits.

---

⬅️ [Previous: Reverse Bits](./006-reverse-bits.md) · [📋 Bit Manipulation list](./README.md) · [Next: Complement of Base 10 Integer](./008-complement-of-base-10-integer.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
