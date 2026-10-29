# 8. Daily Temperatures

**LeetCode 739** · 🟡 Medium · Pattern: **Monotonic stack of indexes**

## The problem, in short

For each day, return how many days you must wait for a warmer temperature, or 0 if none comes.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/daily-temperatures/](https://leetcode.com/problems/daily-temperatures/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/008-daily-temperatures.html](https://amitxaidev.github.io/dsa/18-stack-queue/008-daily-temperatures.html)

## Understanding

**Really asking:** for each day, how many days until a warmer one?

**Why this works:** a stack of waiting days (cooler ones on top). A warmer day pops them and fills in their wait.

**Example:** [73, 74, 75, 71, 69, 72, 76]
```text
74 answers 73 (1), 75 answers 74 (1)
72 answers 69 (1) and 71 (2)
76 answers 72 (1) and 75 (4)
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep a stack of day indexes still waiting for a warmer day.

</details>

<details>
<summary>💡 Hint 2</summary>

The stack's temperatures are decreasing from bottom to top.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each day i, while today is warmer than the day on top of the stack, pop it and set its answer to i − thatDay. Push i.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] ans = new int[temps.length];
        Deque<Integer> stack = new ArrayDeque<>();   // indexes, decreasing temps
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                int day = stack.pop();
                ans[day] = i - day;
            }
            stack.push(i);
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n) — each index is pushed and popped once.
- **Space:** O(n).

## Common mistake

⚠️ Storing temperatures instead of indexes — you need the index to compute the wait.

---

⬅️ [Previous: Evaluate Reverse Polish Notation](./007-evaluate-reverse-polish-notation.md) · [📋 Stack & Queue list](./README.md) · [Next: Next Greater Element II](./009-next-greater-element-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
