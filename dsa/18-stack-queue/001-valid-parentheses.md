# 1. Valid Parentheses

**LeetCode 20** · 🟢 Easy · Pattern: **Stack matching**

## The problem, in short

Decide whether a string of ()[]{} brackets is balanced: every opener is closed by the same type, in the right order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/001-valid-parentheses.html](https://amitxaidev.github.io/dsa/18-stack-queue/001-valid-parentheses.html)

## Understanding

**Really asking:** does every bracket close in the right order?

**Why this works:** the most recent unclosed bracket must close first — that's a stack.

**Example:** "([]{})"
```text
push ) ] → pop ] ✓ → push } → pop } ✓ → pop ) ✓
stack empty → valid
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The most recent unclosed opener must be closed first — that's a stack.

</details>

<details>
<summary>💡 Hint 2</summary>

Push the expected closer when you see an opener; when you see a closer, pop and compare.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Use an ArrayDeque as a stack. For an opener push its matching closer. For a closer, the stack must be non-empty and its top must equal it. At the end the stack must be empty.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;   // wrong or missing opener
        }
        return stack.isEmpty();
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Forgetting to check that the stack is empty at the end ("((" is not valid).

---

[📋 Stack & Queue list](./README.md) · [Next: Implement Queue using Stacks](./002-implement-queue-using-stacks.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
