# 4. Counting Bits

**LeetCode 338** · 🟢 Easy · Pattern: **Bits + DP**

## The problem, in short

For every i from 0 to n, return how many 1-bits i has.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/counting-bits/](https://leetcode.com/problems/counting-bits/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/004-counting-bits.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/004-counting-bits.html)

## Understanding

**Really asking:** the number of 1-bits for every number from 0 to n.

**Why this works:** i >> 1 is i without its last bit, and we already know its answer. Add back the last bit with i & 1.

**Example:** n = 5
```text
0:0  1:1  2:bits[1]+0=1  3:bits[1]+1=2
4:bits[2]+0=1  5:bits[2]+1=2
[0, 1, 1, 2, 1, 2]
```

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

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
