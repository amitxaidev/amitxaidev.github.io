# 10. Online Stock Span

**LeetCode 901** · 🟡 Medium · Pattern: **Monotonic stack with spans**

## The problem, in short

Prices arrive one per day. For each new price, return its span: the number of consecutive days up to today with price less than or equal to today's.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/online-stock-span/](https://leetcode.com/problems/online-stock-span/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/010-online-stock-span.html](https://amitxaidev.github.io/dsa/18-stack-queue/010-online-stock-span.html)

## Understanding

**Really asking:** how many consecutive days up to today had a price ≤ today's?

**Why this works:** smaller earlier prices can be merged into today's span forever; keep (price, span) on a stack.

**Example:** 100, 80, 60, 70, 60, 75, 85
```text
spans 1, 1, 1, 2, 1, 4, 6
```

## Hints

<details>
<summary>💡 Hint 1</summary>

When today's price is higher than an earlier day, that earlier day will never be the "blocker" for any later day.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a stack of (price, span) and merge smaller prices into today's span.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

next(price): span = 1; while the top's price &lt;= price, pop it and add its span. Push (price, span) and return span.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class StockSpanner {
    private final Deque<int[]> stack = new ArrayDeque<>();   // {price, span}

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];   // absorb smaller days
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
```

</details>

## Complexity

- **Time:** Amortised O(1) per call.
- **Space:** O(n).

## Common mistake

⚠️ Using &lt; instead of &lt;= — equal prices should be included in the span.

---

⬅️ [Previous: Next Greater Element II](./009-next-greater-element-ii.md) · [📋 Stack & Queue list](./README.md) · [Next: Asteroid Collision](./011-asteroid-collision.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
