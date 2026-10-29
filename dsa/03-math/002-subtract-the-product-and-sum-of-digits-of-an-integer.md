# 2. Subtract the Product and Sum of Digits of an Integer

**LeetCode 1281** · 🟢 Easy · Pattern: **Digit extraction**
🔗 Solve it here: [https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/002-subtract-the-product-and-sum-of-digits-of-an-integer.html](https://amitxaidev.github.io/dsa/03-math/002-subtract-the-product-and-sum-of-digits-of-an-integer.html)

## The problem, in short

Return (product of the digits) minus (sum of the digits) of a positive integer.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

n % 10 gives the last digit, n / 10 removes it.

</details>

<details>
<summary>💡 Hint 2</summary>

Start the product at 1 and the sum at 0.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Extract digits one by one, updating the product and the sum, then subtract.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            int d = n % 10;
            product *= d;
            sum += d;
            n /= 10;
        }
        return product - sum;
    }
}
```

</details>

## Complexity

- **Time:** O(log10 n).
- **Space:** O(1).

## Common mistake

⚠️ Starting the product at 0, which makes it 0 forever.

---

⬅️ [Previous: Palindrome Number](./001-palindrome-number.md) · [📋 Basic Math list](./README.md) · [Next: Count the Digits That Divide a Number](./003-count-the-digits-that-divide-a-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
