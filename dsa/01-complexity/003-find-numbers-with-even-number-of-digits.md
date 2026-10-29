# 3. Find Numbers with Even Number of Digits

**LeetCode 1295** · 🟢 Easy · Pattern: **Digit counting**

## The problem, in short

Count how many numbers in the array have an even count of digits (for example 12 and 4321 qualify, 7 and 123 do not).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/find-numbers-with-even-number-of-digits/](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/003-find-numbers-with-even-number-of-digits.html](https://amitxaidev.github.io/dsa/01-complexity/003-find-numbers-with-even-number-of-digits.html)

## Understanding

**Really asking:** how many numbers have 2, 4, 6… digits?

**Why this works:** dividing by 10 chops off one digit, so counting digits takes about log10(x) steps. This is your first logarithmic loop.

**Example:** nums = [12, 345, 2, 6, 7896]
```text
12   → 1 → 0          2 digits  ✓
345  → 34 → 3 → 0     3 digits
2    → 0              1 digit
6    → 0              1 digit
7896 → 789 → 78 → 7 → 0   4 digits ✓
answer: 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Count digits by dividing by 10 until the number becomes 0.

</details>

<details>
<summary>💡 Hint 2</summary>

Dividing by 10 removes one digit, so counting digits of x takes O(log x) steps, not O(x).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each number count its digits with repeated division by 10 and check if the count is even. The inner loop runs about log10(x) times, so the total is O(n · log M) where M is the largest value. This is a good first example of a logarithmic loop.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            int digits = 0;
            while (x > 0) {      // runs log10(x) times
                x /= 10;
                digits++;
            }
            if (digits % 2 == 0) count++;
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n · log M), M = largest number.
- **Space:** O(1).

## Common mistake

⚠️ Converting each number to a String works but hides the cost; also forgetting that 0 has one digit (not a concern here since values are positive, but remember it in general).

---

⬅️ [Previous: Richest Customer Wealth](./002-richest-customer-wealth.md) · [📋 Time & Space Complexity list](./README.md) · [Next: How Many Numbers Are Smaller Than the Current Number](./004-how-many-numbers-are-smaller-than-the-current-number.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
