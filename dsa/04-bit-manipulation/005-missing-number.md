# 5. Missing Number

**LeetCode 268** · 🟢 Easy · Pattern: **XOR**

## The problem, in short

The array holds n distinct numbers taken from 0..n. Exactly one is missing; find it.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/missing-number/](https://leetcode.com/problems/missing-number/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/005-missing-number.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/005-missing-number.html)

## Understanding

**Really asking:** numbers 0..n with one missing; which one?

**Why this works:** XOR all indexes 0..n with all values. Every number that is present shows up twice and cancels.

**Example:** nums = [3, 0, 1], n = 3
```text
start x = 3
^0^3 → 0, ^1^0 → 1, ^2^1 → 2
answer 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

XOR every index 0..n with every value. Everything present appears twice.

</details>

<details>
<summary>💡 Hint 2</summary>

The sum formula n(n+1)/2 also works, but XOR can't overflow.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Start with x = n, then XOR in each index i and each value nums[i]. Every number that is present cancels, leaving the missing one.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int missingNumber(int[] nums) {
        int x = nums.length;            // include n
        for (int i = 0; i < nums.length; i++) {
            x ^= i ^ nums[i];
        }
        return x;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting to include n itself in the XOR (the indexes only go to n - 1).

---

⬅️ [Previous: Counting Bits](./004-counting-bits.md) · [📋 Bit Manipulation list](./README.md) · [Next: Reverse Bits](./006-reverse-bits.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
