# 4. Add Digits

**LeetCode 258** · 🟢 Easy · Pattern: **Digital root**
🔗 Solve it here: [https://leetcode.com/problems/add-digits/](https://leetcode.com/problems/add-digits/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/004-add-digits.html](https://amitxaidev.github.io/dsa/03-math/004-add-digits.html)

## The problem, in short

Keep replacing a number with the sum of its digits until only one digit is left, and return that digit.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The simple loop works. Can you find an O(1) formula?

</details>

<details>
<summary>💡 Hint 2</summary>

A number and its digit sum leave the same remainder when divided by 9.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

This is the digital root. For num = 0 the answer is 0; otherwise it is 1 + (num - 1) % 9, which maps multiples of 9 to 9 instead of 0.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;   // digital root formula
    }
}
```

</details>

## Complexity

- **Time:** O(1).
- **Space:** O(1).

## Common mistake

⚠️ Using num % 9 directly, which gives 0 for 9, 18, 27… instead of 9.

---

⬅️ [Previous: Count the Digits That Divide a Number](./003-count-the-digits-that-divide-a-number.md) · [📋 Basic Math list](./README.md) · [Next: Find Greatest Common Divisor of Array](./005-find-greatest-common-divisor-of-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
