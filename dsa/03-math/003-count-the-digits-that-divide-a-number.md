# 3. Count the Digits That Divide a Number

**LeetCode 2520** · 🟢 Easy · Pattern: **Digit extraction + modulo**
🔗 Solve it here: [https://leetcode.com/problems/count-the-digits-that-divide-a-number/](https://leetcode.com/problems/count-the-digits-that-divide-a-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/003-count-the-digits-that-divide-a-number.html](https://amitxaidev.github.io/dsa/03-math/003-count-the-digits-that-divide-a-number.html)

## The problem, in short

Count how many digits of num (counting repeats) divide num evenly. num contains no zero digits.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep the original number in a separate variable — you'll destroy the copy while extracting digits.

</details>

<details>
<summary>💡 Hint 2</summary>

A digit d divides num when num % d == 0.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Copy num, extract each digit from the copy, and test the original with modulo.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int countDigits(int num) {
        int count = 0;
        for (int x = num; x > 0; x /= 10) {
            if (num % (x % 10) == 0) count++;   // digit divides the ORIGINAL number
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(log10 n).
- **Space:** O(1).

## Common mistake

⚠️ Testing divisibility against the shrinking copy instead of the original number.

---

⬅️ [Previous: Subtract the Product and Sum of Digits of an Integer](./002-subtract-the-product-and-sum-of-digits-of-an-integer.md) · [📋 Basic Math list](./README.md) · [Next: Add Digits](./004-add-digits.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
