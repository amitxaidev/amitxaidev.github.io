# 8. Shuffle String

**LeetCode 1528** · 🟢 Easy · Pattern: **char[] basics**
🔗 Solve it here: [https://leetcode.com/problems/shuffle-string/](https://leetcode.com/problems/shuffle-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/008-shuffle-string.html](https://amitxaidev.github.io/dsa/02-java-basics/008-shuffle-string.html)

## The problem, in short

Character i of the string must move to position indices[i]. Return the rearranged string.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Create a char array of the same length.

</details>

<details>
<summary>💡 Hint 2</summary>

Place s.charAt(i) at result[indices[i]], then build a String from the array.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Use a char[] as a writable buffer since Strings are immutable, then convert with new String(chars).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[indices[i]] = s.charAt(i);   // char i goes to indices[i]
        }
        return new String(res);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Reading result[i] = s.charAt(indices[i]) — that applies the move in the wrong direction.

---

⬅️ [Previous: Kids With the Greatest Number of Candies](./007-kids-with-the-greatest-number-of-candies.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Count Items Matching a Rule](./009-count-items-matching-a-rule.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
