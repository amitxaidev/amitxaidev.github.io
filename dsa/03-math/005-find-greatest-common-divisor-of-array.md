# 5. Find Greatest Common Divisor of Array

**LeetCode 1979** · 🟢 Easy · Pattern: **Euclid's GCD**
🔗 Solve it here: [https://leetcode.com/problems/find-greatest-common-divisor-of-array/](https://leetcode.com/problems/find-greatest-common-divisor-of-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/005-find-greatest-common-divisor-of-array.html](https://amitxaidev.github.io/dsa/03-math/005-find-greatest-common-divisor-of-array.html)

## The problem, in short

Return the GCD of the smallest and largest numbers in the array.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Find min and max in one pass.

</details>

<details>
<summary>💡 Hint 2</summary>

Euclid: gcd(a, b) = gcd(b, a % b), and gcd(a, 0) = a.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass for min and max, then Euclid's algorithm, which shrinks the numbers fast — O(log min(a, b)) steps.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
```

</details>

## Complexity

- **Time:** O(n + log M).
- **Space:** O(1).

## Common mistake

⚠️ Computing the GCD of all elements — the problem asks only for min and max.

---

⬅️ [Previous: Add Digits](./004-add-digits.md) · [📋 Basic Math list](./README.md) · [Next: Greatest Common Divisor of Strings](./006-greatest-common-divisor-of-strings.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
