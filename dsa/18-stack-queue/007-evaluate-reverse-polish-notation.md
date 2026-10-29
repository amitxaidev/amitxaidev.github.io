# 7. Evaluate Reverse Polish Notation

**LeetCode 150** · 🟡 Medium · Pattern: **Operand stack**

## The problem, in short

Evaluate an arithmetic expression in Reverse Polish (postfix) notation with + - * / on integers. Division truncates toward zero.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/evaluate-reverse-polish-notation/](https://leetcode.com/problems/evaluate-reverse-polish-notation/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/007-evaluate-reverse-polish-notation.html](https://amitxaidev.github.io/dsa/18-stack-queue/007-evaluate-reverse-polish-notation.html)

## Understanding

**Really asking:** compute a postfix expression.

**Why this works:** numbers go on a stack; an operator pops two, applies, and pushes the result.

**Example:** ["2", "1", "+", "3", "*"]
```text
2, 1 → + → 3
3, 3 → * → 9
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Push numbers. On an operator, pop two numbers, apply it, push the result.

</details>

<details>
<summary>💡 Hint 2</summary>

The first pop is the right operand.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan tokens with a stack. For an operator, b = pop, a = pop, push a op b. The final stack top is the answer. Java's int division already truncates toward zero.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String t : tokens) {
            switch (t) {
                case "+": st.push(st.pop() + st.pop()); break;
                case "*": st.push(st.pop() * st.pop()); break;
                case "-": { int b = st.pop(), a = st.pop(); st.push(a - b); break; }   // order matters
                case "/": { int b = st.pop(), a = st.pop(); st.push(a / b); break; }
                default: st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Swapping operands for - and /, giving b − a instead of a − b.

---

⬅️ [Previous: Min Stack](./006-min-stack.md) · [📋 Stack & Queue list](./README.md) · [Next: Daily Temperatures](./008-daily-temperatures.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
