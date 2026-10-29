# 2. Implement Queue using Stacks

**LeetCode 232** · 🟢 Easy · Pattern: **Two stacks**
🔗 Solve it here: [https://leetcode.com/problems/implement-queue-using-stacks/](https://leetcode.com/problems/implement-queue-using-stacks/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/002-implement-queue-using-stacks.html](https://amitxaidev.github.io/dsa/18-stack-queue/002-implement-queue-using-stacks.html)

## The problem, in short

Build a FIFO queue (push, pop, peek, empty) using only stack operations.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Use an "in" stack for pushes and an "out" stack for pops.

</details>

<details>
<summary>💡 Hint 2</summary>

Only when "out" is empty, pour everything from "in" into "out" — that reverses the order.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

push → in.push. pop/peek → if out is empty, move all of in to out, then use out's top. Each element moves at most once, so operations are amortised O(1).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class MyQueue {
    private final Deque<Integer> in = new ArrayDeque<>(), out = new ArrayDeque<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());   // reverse once
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
```

</details>

## Complexity

- **Time:** Amortised O(1) per operation.
- **Space:** O(n).

## Common mistake

⚠️ Pouring from in to out on every pop even when out isn't empty — that breaks the order.

---

⬅️ [Previous: Valid Parentheses](./001-valid-parentheses.md) · [📋 Stack & Queue list](./README.md) · [Next: Implement Stack using Queues](./003-implement-stack-using-queues.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
