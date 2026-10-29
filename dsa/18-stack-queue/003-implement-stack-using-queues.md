# 3. Implement Stack using Queues

**LeetCode 225** · 🟢 Easy · Pattern: **Rotate on push**
🔗 Solve it here: [https://leetcode.com/problems/implement-stack-using-queues/](https://leetcode.com/problems/implement-stack-using-queues/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/003-implement-stack-using-queues.html](https://amitxaidev.github.io/dsa/18-stack-queue/003-implement-stack-using-queues.html)

## The problem, in short

Build a LIFO stack (push, pop, top, empty) using only queue operations.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

After adding a new element to the back, rotate the older elements behind it.

</details>

<details>
<summary>💡 Hint 2</summary>

Then the newest element is always at the front of the queue.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One queue. push: offer x, then poll and re-offer the previous size elements. pop/top are just poll/peek.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class MyStack {
    private final Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) q.offer(q.poll());   // move older items behind x
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
```

</details>

## Complexity

- **Time:** push O(n), pop/top O(1).
- **Space:** O(n).

## Common mistake

⚠️ Using a Deque's stack methods (push/pop) — that defeats the exercise. Stick to offer/poll/peek.

---

⬅️ [Previous: Implement Queue using Stacks](./002-implement-queue-using-stacks.md) · [📋 Stack & Queue list](./README.md) · [Next: Next Greater Element I](./004-next-greater-element-i.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
