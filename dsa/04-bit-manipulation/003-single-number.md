# 3. Single Number

**LeetCode 136** · 🟢 Easy · Pattern: **XOR**
🔗 Solve it here: [https://leetcode.com/problems/single-number/](https://leetcode.com/problems/single-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/003-single-number.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/003-single-number.html)

## The problem, in short

Every number appears twice except one. Find that one in linear time and constant extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

What is a ^ a? What is a ^ 0?

</details>

<details>
<summary>💡 Hint 2</summary>

XOR is order-independent, so pairs cancel no matter where they are.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

XOR all numbers together. Every pair becomes 0 and the single number is left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int v : nums) x ^= v;   // pairs cancel out
        return x;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Reaching for a HashMap — it works but uses O(n) space, which the problem asks you to avoid.

---

⬅️ [Previous: Power of Two](./002-power-of-two.md) · [📋 Bit Manipulation list](./README.md) · [Next: Counting Bits](./004-counting-bits.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
