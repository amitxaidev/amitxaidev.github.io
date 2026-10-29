# 6. Greatest Common Divisor of Strings

**LeetCode 1071** · 🟢 Easy · Pattern: **GCD on lengths**
🔗 Solve it here: [https://leetcode.com/problems/greatest-common-divisor-of-strings/](https://leetcode.com/problems/greatest-common-divisor-of-strings/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/03-math/006-greatest-common-divisor-of-strings.html](https://amitxaidev.github.io/dsa/03-math/006-greatest-common-divisor-of-strings.html)

## The problem, in short

A string t "divides" s if s is t repeated some number of times. Return the longest string that divides both inputs, or "" if none.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If a common divisor exists, then s1 + s2 must equal s2 + s1.

</details>

<details>
<summary>💡 Hint 2</summary>

When it exists, its length is gcd(len1, len2).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Check the concatenation trick first. If s1 + s2 equals s2 + s1, both are built from the same block, and the longest block has length gcd of the two lengths.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

</details>

## Complexity

- **Time:** O(n + m) for the string comparison.
- **Space:** O(n + m) for the concatenations.

## Common mistake

⚠️ Trying every prefix length and checking divisibility by brute force, which is much slower and easy to get wrong.

---

⬅️ [Previous: Find Greatest Common Divisor of Array](./005-find-greatest-common-divisor-of-array.md) · [📋 Basic Math list](./README.md) · [Next: Ugly Number](./007-ugly-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
