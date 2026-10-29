# 6. Min Stack

**LeetCode 155** · 🟡 Medium · Pattern: **Stack of (value, min) pairs**
🔗 Solve it here: [https://leetcode.com/problems/min-stack/](https://leetcode.com/problems/min-stack/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/006-min-stack.html](https://amitxaidev.github.io/dsa/18-stack-queue/006-min-stack.html)

## The problem, in short

Design a stack that supports push, pop, top and getMin, all in O(1).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The minimum changes only when you push or pop.

</details>

<details>
<summary>💡 Hint 2</summary>

Store, with each element, the minimum of the stack at that moment.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Push pairs [value, min(value, current min)]. getMin reads the top pair's second field. Popping restores the previous minimum automatically.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class MinStack {
    private final Deque<int[]> stack = new ArrayDeque<>();   // {value, min so far}

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);
        stack.push(new int[]{val, min});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
```

</details>

## Complexity

- **Time:** O(1) per operation.
- **Space:** O(n).

## Common mistake

⚠️ Keeping a single min variable — after popping the minimum you don't know the next one.

---

⬅️ [Previous: Backspace String Compare](./005-backspace-string-compare.md) · [📋 Stack & Queue list](./README.md) · [Next: Evaluate Reverse Polish Notation](./007-evaluate-reverse-polish-notation.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
