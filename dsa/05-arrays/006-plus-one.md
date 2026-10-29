# 6. Plus One

**LeetCode 66** · 🟢 Easy · Pattern: **Carry handling**

## The problem, in short

A large integer is stored as an array of digits, most significant first. Add one and return the new digit array.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/plus-one/](https://leetcode.com/problems/plus-one/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/006-plus-one.html](https://amitxaidev.github.io/dsa/05-arrays/006-plus-one.html)

## Understanding

**Really asking:** add 1 to a big number stored as a digit array.

**Why this works:** like adding on paper from the right. A 9 becomes 0 and carries; the first non-9 just goes up by one.

**Example:** [1, 2, 9, 9]
```text
9 → 0 (carry), 9 → 0 (carry)
2 → 3, stop
[1, 3, 0, 0]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Start from the last digit. If it's below 9, just increment and stop.

</details>

<details>
<summary>💡 Hint 2</summary>

A 9 becomes 0 and the carry moves left.

</details>

<details>
<summary>💡 Hint 3</summary>

If every digit was 9, you need a new array one longer.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk from the end. The first digit that isn't 9 absorbs the +1 and we return. If the loop finishes, the number was all 9s, so return 1 followed by zeros.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;   // 9 + 1 = 10, carry continues
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;          // 999 -> 1000
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1), or O(n) in the all-9s case.

## Common mistake

⚠️ Converting the digits to an int or long — the array can be 100 digits long.

---

⬅️ [Previous: Find All Numbers Disappeared in an Array](./005-find-all-numbers-disappeared-in-an-array.md) · [📋 Arrays list](./README.md) · [Next: Merge Sorted Array](./007-merge-sorted-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
