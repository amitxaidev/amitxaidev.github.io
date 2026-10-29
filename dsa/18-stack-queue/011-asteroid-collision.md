# 11. Asteroid Collision

**LeetCode 735** · 🟡 Medium · Pattern: **Stack simulation**

## The problem, in short

Asteroids move along a line: positive values go right, negative go left, absolute value is size. When two collide, the smaller explodes; equal sizes both explode. Return the survivors.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/asteroid-collision/](https://leetcode.com/problems/asteroid-collision/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/011-asteroid-collision.html](https://amitxaidev.github.io/dsa/18-stack-queue/011-asteroid-collision.html)

## Understanding

**Really asking:** right-moving and left-moving asteroids crash; what's left?

**Why this works:** only a left-mover arriving after a right-mover collides. The stack holds survivors; the new left-mover fights the top.

**Example:** [5, 10, -5]
```text
5, 10 on stack
-5 meets 10 → -5 explodes → [5, 10]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Only a right-moving asteroid followed by a left-moving one can collide.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep survivors in a stack; a new left-mover fights the right-movers on top.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each asteroid a: while a &lt; 0 and the top is positive and smaller than |a|, pop. Then if the top is positive and equal to |a|, pop it and drop a; if the top is positive and bigger, drop a; otherwise push a.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean alive = true;
            while (alive && a < 0 && !st.isEmpty() && st.peek() > 0) {
                int top = st.peek();
                if (top < -a) { st.pop(); continue; }   // top explodes, keep fighting
                if (top == -a) st.pop();                // both explode
                alive = false;                          // a explodes
            }
            if (alive) st.push(a);
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = st.pop();
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Making a left-mover collide with a left-mover or a right-mover that comes after it.

---

⬅️ [Previous: Online Stock Span](./010-online-stock-span.md) · [📋 Stack & Queue list](./README.md) · [Next: Remove K Digits](./012-remove-k-digits.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
