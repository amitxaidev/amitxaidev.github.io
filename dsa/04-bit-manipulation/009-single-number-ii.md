# 9. Single Number II

**LeetCode 137** · 🟡 Medium · Pattern: **Bit counting**
🔗 Solve it here: [https://leetcode.com/problems/single-number-ii/](https://leetcode.com/problems/single-number-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/009-single-number-ii.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/009-single-number-ii.html)

## The problem, in short

Every number appears three times except one, which appears once. Find it with O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

XOR alone doesn't work because three copies don't cancel.

</details>

<details>
<summary>💡 Hint 2</summary>

Look at each bit position separately: count how many numbers have that bit set.

</details>

<details>
<summary>💡 Hint 3</summary>

If the count isn't a multiple of 3, the single number has that bit.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each of the 32 bit positions, sum the bits across all numbers and take the total mod 3. The remainder is the single number's bit. Rebuild the answer from those bits. Works for negatives too because we handle bit 31 like any other.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int x : nums) count += (x >> bit) & 1;
            if (count % 3 != 0) result |= (1 << bit);   // the single number owns this bit
        }
        return result;
    }
}
```

</details>

## Complexity

- **Time:** O(32·n) = O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using a HashMap of counts — correct but O(n) space.

---

⬅️ [Previous: Complement of Base 10 Integer](./008-complement-of-base-10-integer.md) · [📋 Bit Manipulation list](./README.md) · [Next: Single Number III](./010-single-number-iii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
