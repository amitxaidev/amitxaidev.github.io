# 4. Reverse String

**LeetCode 344** · 🟢 Easy · Pattern: **Two pointers**
🔗 Solve it here: [https://leetcode.com/problems/reverse-string/](https://leetcode.com/problems/reverse-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/004-reverse-string.html](https://amitxaidev.github.io/dsa/02-java-basics/004-reverse-string.html)

## The problem, in short

Reverse a char array in place without making a new array.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Swap the first and last characters, then move inward.

</details>

<details>
<summary>💡 Hint 2</summary>

Stop when the two indexes meet.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a left index at 0 and a right index at the end, swap, and move both toward the middle. Each swap fixes two positions, so n/2 swaps reverse the array.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];   // classic swap with a temp variable
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Looping over the whole array and swapping every pair twice, which puts everything back where it started.

---

⬅️ [Previous: Fizz Buzz](./003-fizz-buzz.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Defanging an IP Address](./005-defanging-an-ip-address.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
