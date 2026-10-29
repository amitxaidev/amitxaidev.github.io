# 11. Factorial Trailing Zeroes

**LeetCode 172** · 🟡 Medium · Pattern: **Counting factors**
🔗 Solve it here: [https://leetcode.com/problems/factorial-trailing-zeroes/](https://leetcode.com/problems/factorial-trailing-zeroes/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/011-factorial-trailing-zeroes.html](https://amitxaidev.github.io/dsa/03-math/011-factorial-trailing-zeroes.html)

## The problem, in short

Return how many zeros n! ends with.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Each trailing zero comes from a factor 10 = 2 × 5.

</details>

<details>
<summary>💡 Hint 2</summary>

There are always more 2s than 5s, so count the 5s.

</details>

<details>
<summary>💡 Hint 3</summary>

25 contributes two 5s, 125 three… count n/5 + n/25 + n/125 + …

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep dividing n by 5 and add each quotient. That counts multiples of 5, then extra 5s from multiples of 25, and so on.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;   // multiples of 5, then 25, then 125...
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(log5 n).
- **Space:** O(1).

## Common mistake

⚠️ Computing n! directly — it overflows almost immediately.

---

⬅️ [Previous: Pow(x, n)](./010-powx-n.md) · [📋 Basic Math list](./README.md) · [Next: Count Good Numbers](./012-count-good-numbers.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
