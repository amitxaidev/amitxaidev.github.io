# 10. Single Number III

**LeetCode 260** · 🟡 Medium · Pattern: **XOR + lowest set bit**
🔗 Solve it here: [https://leetcode.com/problems/single-number-iii/](https://leetcode.com/problems/single-number-iii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/010-single-number-iii.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/010-single-number-iii.html)

## The problem, in short

Every number appears twice except two different numbers that appear once each. Return those two.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

XOR of everything gives a ^ b, which is non-zero because a != b.

</details>

<details>
<summary>💡 Hint 2</summary>

Any set bit of a ^ b is a bit where a and b differ.

</details>

<details>
<summary>💡 Hint 3</summary>

Split all numbers into two groups by that bit and XOR each group.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

x = XOR of all. Pick its lowest set bit with x & -x. Numbers with that bit set go to group A, the rest to B. Pairs land in the same group and cancel, leaving a in one group and b in the other.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int v : nums) xor ^= v;
        int bit = xor & -xor;        // lowest bit where the two answers differ
        int a = 0, b = 0;
        for (int v : nums) {
            if ((v & bit) != 0) a ^= v;
            else b ^= v;
        }
        return new int[]{a, b};
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using x & (x - 1) to pick the bit — that clears the lowest set bit instead of isolating it. Use x & -x.

---

⬅️ [Previous: Single Number II](./009-single-number-ii.md) · [📋 Bit Manipulation list](./README.md) · [Next: Sum of Two Integers](./011-sum-of-two-integers.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
