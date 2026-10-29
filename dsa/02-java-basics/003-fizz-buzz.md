# 3. Fizz Buzz

**LeetCode 412** · 🟢 Easy · Pattern: **Strings & List**
🔗 Solve it here: [https://leetcode.com/problems/fizz-buzz/](https://leetcode.com/problems/fizz-buzz/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/003-fizz-buzz.html](https://amitxaidev.github.io/dsa/02-java-basics/003-fizz-buzz.html)

## The problem, in short

For numbers 1 to n, produce a list of strings: "FizzBuzz" for multiples of both 3 and 5, "Fizz" for multiples of 3, "Buzz" for multiples of 5, and the number itself otherwise.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Check the "both" case first, or build the string piece by piece.

</details>

<details>
<summary>💡 Hint 2</summary>

Use a List&lt;String> and String.valueOf(i) for plain numbers.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Loop from 1 to n, use the modulo operator to test divisibility and add the right string to an ArrayList.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) ans.add("FizzBuzz");      // divisible by both
            else if (i % 3 == 0) ans.add("Fizz");
            else if (i % 5 == 0) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the output list.

## Common mistake

⚠️ Checking i % 3 before i % 15, so 15 prints "Fizz" instead of "FizzBuzz".

---

⬅️ [Previous: Shuffle the Array](./002-shuffle-the-array.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Reverse String](./004-reverse-string.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
