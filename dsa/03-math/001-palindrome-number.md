# 1. Palindrome Number

**LeetCode 9** · 🟢 Easy · Pattern: **Digit reversal**

## The problem, in short

Decide whether an integer reads the same forwards and backwards, without converting it to a string.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/palindrome-number/](https://leetcode.com/problems/palindrome-number/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/001-palindrome-number.html](https://amitxaidev.github.io/dsa/03-math/001-palindrome-number.html)

## Understanding

**Really asking:** do the digits read the same from both ends, without turning the number into a string?

**Why this works:** build the reverse of the second half digit by digit. When the reversed half catches up with the front half, compare them. Half is enough, and it can't overflow.

**Example:** x = 1221
```text
x=1221, rev=0 → rev=1, x=122
x=122,  rev=1 → rev=12, x=12
x == rev (12 == 12) → palindrome
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Negative numbers are never palindromes because of the minus sign.

</details>

<details>
<summary>💡 Hint 2</summary>

Peel digits off the end with % 10 and build the reversed number.

</details>

<details>
<summary>💡 Hint 3</summary>

You only need to reverse half: stop when the reversed half is at least the remaining half.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Reject negatives and numbers ending in 0 (except 0 itself). Move digits from x into rev until rev >= x. For even length x == rev, for odd length x == rev / 10 (the middle digit doesn't matter). Reversing only half also avoids overflow.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;   // move last digit of x to rev
            x /= 10;
        }
        return x == rev || x == rev / 10;   // odd length: drop the middle digit
    }
}
```

</details>

## Complexity

- **Time:** O(log10 n) — one step per digit.
- **Space:** O(1).

## Common mistake

⚠️ Reversing the whole number into an int, which can overflow for large inputs.

---

[📋 Basic Math list](./README.md) · [Next: Subtract the Product and Sum of Digits of an Integer](./002-subtract-the-product-and-sum-of-digits-of-an-integer.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
