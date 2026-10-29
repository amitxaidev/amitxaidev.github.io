# 2. Power of Two

**LeetCode 231** · 🟢 Easy · Pattern: **n & (n-1)**
🔗 Solve it here: [https://leetcode.com/problems/power-of-two/](https://leetcode.com/problems/power-of-two/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/002-power-of-two.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/002-power-of-two.html)

## The problem, in short

Decide whether n is a power of two.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Powers of two have exactly one bit set: 1, 10, 100, 1000 in binary.

</details>

<details>
<summary>💡 Hint 2</summary>

What does n & (n - 1) give when only one bit is set?

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

A positive n is a power of two when clearing its lowest set bit leaves 0.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

</details>

## Complexity

- **Time:** O(1).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting n > 0. For n = 0, 0 & -1 is 0 and you'd wrongly return true; negatives also break it.

---

⬅️ [Previous: Number of 1 Bits](./001-number-of-1-bits.md) · [📋 Bit Manipulation list](./README.md) · [Next: Single Number](./003-single-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
