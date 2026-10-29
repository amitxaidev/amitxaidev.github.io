# 5. Defanging an IP Address

**LeetCode 1108** · 🟢 Easy · Pattern: **StringBuilder**
🔗 Solve it here: [https://leetcode.com/problems/defanging-an-ip-address/](https://leetcode.com/problems/defanging-an-ip-address/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/005-defanging-an-ip-address.html](https://amitxaidev.github.io/dsa/02-java-basics/005-defanging-an-ip-address.html)

## The problem, in short

Replace every "." in an IPv4 address with "[.]".

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Strings in Java are immutable — building a new one with + in a loop creates many copies.

</details>

<details>
<summary>💡 Hint 2</summary>

Use a StringBuilder and append character by character.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk through the characters; append "[.]" for a dot and the character otherwise. StringBuilder keeps this O(n). (address.replace(".", "[.]") also works and is fine in an interview if you can explain it.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') sb.append("[.]");
            else sb.append(c);
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the result.

## Common mistake

⚠️ Using replaceAll(".", ...) — replaceAll takes a regex, and "." matches every character.

---

⬅️ [Previous: Reverse String](./004-reverse-string.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Maximum Number of Words Found in Sentences](./006-maximum-number-of-words-found-in-sentences.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
