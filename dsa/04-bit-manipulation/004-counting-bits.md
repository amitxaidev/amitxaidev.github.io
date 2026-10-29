# 4. Counting Bits

**LeetCode 338** · 🟢 Easy · Pattern: **Bits + DP**
🔗 Solve it here: [https://leetcode.com/problems/counting-bits/](https://leetcode.com/problems/counting-bits/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/004-counting-bits.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/004-counting-bits.html)

## The problem, in short

For every i from 0 to n, return how many 1-bits i has.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The answer for i is related to the answer for i >> 1.

</details>

<details>
<summary>💡 Hint 2</summary>

Shifting right drops the last bit; add it back with i & 1.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

bits[i] = bits[i >> 1] + (i & 1). Each value reuses an already computed smaller value, so the whole array fills in O(n).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);   // half of i, plus the last bit
        }
        return bits;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the output.

## Common mistake

⚠️ Calling a popcount loop for every i — O(n log n). Fine, but the reuse trick is what interviewers look for.

---

⬅️ [Previous: Single Number](./003-single-number.md) · [📋 Bit Manipulation list](./README.md) · [Next: Missing Number](./005-missing-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
