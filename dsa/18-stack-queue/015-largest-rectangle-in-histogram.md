# 15. Largest Rectangle in Histogram

**LeetCode 84** · 🔴 Hard · Pattern: **Monotonic stack**
🔗 Solve it here: [https://leetcode.com/problems/largest-rectangle-in-histogram/](https://leetcode.com/problems/largest-rectangle-in-histogram/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/015-largest-rectangle-in-histogram.html](https://amitxaidev.github.io/dsa/18-stack-queue/015-largest-rectangle-in-histogram.html)

## The problem, in short

Bars of width 1 have given heights. Return the area of the largest rectangle that fits inside the histogram.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For each bar, the widest rectangle of that height stretches until a shorter bar on each side.

</details>

<details>
<summary>💡 Hint 2</summary>

An increasing stack of indexes finds both boundaries: when a bar is popped, the current index is its right boundary and the new top is its left boundary.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan i from 0 to n (with height 0 at n as a sentinel). While the current height is lower than the top's height, pop the top; width = i − newTop − 1 (or i if the stack is empty). Track the best area.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, best = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];   // sentinel bar of height 0
            while (!st.isEmpty() && heights[st.peek()] > h) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                best = Math.max(best, height * width);
            }
            st.push(i);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Forgetting the sentinel at the end, so bars left in the stack are never measured.

---

⬅️ [Previous: Design Circular Queue](./014-design-circular-queue.md) · [📋 Stack & Queue list](./README.md) · [Next: Maximal Rectangle](./016-maximal-rectangle.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
