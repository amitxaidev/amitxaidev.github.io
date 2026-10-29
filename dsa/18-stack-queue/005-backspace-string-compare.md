# 5. Backspace String Compare

**LeetCode 844** · 🟢 Easy · Pattern: **Stack / backwards scan**
🔗 Solve it here: [https://leetcode.com/problems/backspace-string-compare/](https://leetcode.com/problems/backspace-string-compare/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/005-backspace-string-compare.html](https://amitxaidev.github.io/dsa/18-stack-queue/005-backspace-string-compare.html)

## The problem, in short

In two strings, '#' means backspace. Decide whether they're equal after applying the backspaces.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A stack (or StringBuilder) handles it: push letters, pop on '#'.

</details>

<details>
<summary>💡 Hint 2</summary>

For O(1) space, scan both strings from the end, skipping characters that get erased.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

The stack version builds both final strings and compares. The backwards version keeps a skip counter per string and compares the next surviving characters.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        StringBuilder sb = new StringBuilder();   // used as a stack
        for (char c : s.toCharArray()) {
            if (c != '#') sb.append(c);
            else if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(n + m) with the stack version.

## Common mistake

⚠️ Popping from an empty stack when the string starts with '#'.

---

⬅️ [Previous: Next Greater Element I](./004-next-greater-element-i.md) · [📋 Stack & Queue list](./README.md) · [Next: Min Stack](./006-min-stack.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
