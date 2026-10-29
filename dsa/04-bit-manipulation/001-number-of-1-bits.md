# 1. Number of 1 Bits

**LeetCode 191** · 🟢 Easy · Pattern: **n & (n-1)**
🔗 Solve it here: [https://leetcode.com/problems/number-of-1-bits/](https://leetcode.com/problems/number-of-1-bits/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/001-number-of-1-bits.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/001-number-of-1-bits.html)

## The problem, in short

Count how many bits are set to 1 in the binary form of a number.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You can check the last bit with n & 1 and then shift right.

</details>

<details>
<summary>💡 Hint 2</summary>

n & (n - 1) clears the lowest set bit. How many times can you do that before n becomes 0?

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Brian Kernighan's trick: each n & (n - 1) removes exactly one 1-bit, so the loop runs once per set bit.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);   // drop the lowest set bit
            count++;
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(number of set bits) ≤ O(32).
- **Space:** O(1).

## Common mistake

⚠️ Using n >> 1 on a negative int in Java — the sign bit is copied in and the loop never ends. Use >>> or the n & (n - 1) loop.

---

[📋 Bit Manipulation list](./README.md) · [Next: Power of Two](./002-power-of-two.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
