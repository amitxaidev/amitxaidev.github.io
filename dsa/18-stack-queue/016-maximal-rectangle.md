# 16. Maximal Rectangle

**LeetCode 85** · 🔴 Hard · Pattern: **Histogram per row**
🔗 Solve it here: [https://leetcode.com/problems/maximal-rectangle/](https://leetcode.com/problems/maximal-rectangle/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/016-maximal-rectangle.html](https://amitxaidev.github.io/dsa/18-stack-queue/016-maximal-rectangle.html)

## The problem, in short

In a binary matrix of '0' and '1', return the area of the largest rectangle containing only '1's.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Treat each row as the floor of a histogram: height[c] = consecutive '1's ending at this row in column c.

</details>

<details>
<summary>💡 Hint 2</summary>

Then each row is "Largest Rectangle in Histogram".

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Update heights row by row (reset to 0 on '0'), run the monotonic-stack histogram routine, and keep the maximum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length, best = 0;
        int[] heights = new int[n];
        for (char[] row : matrix) {
            for (int c = 0; c < n; c++) heights[c] = row[c] == '1' ? heights[c] + 1 : 0;
            best = Math.max(best, largest(heights));
        }
        return best;
    }

    private int largest(int[] h) {
        int best = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= h.length; i++) {
            int cur = (i == h.length) ? 0 : h[i];
            while (!st.isEmpty() && h[st.peek()] > cur) {
                int height = h[st.pop()];
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

- **Time:** O(m·n).
- **Space:** O(n).

## Common mistake

⚠️ Not resetting the height to 0 when a '0' appears, which lets rectangles pass through zeros.

---

⬅️ [Previous: Largest Rectangle in Histogram](./015-largest-rectangle-in-histogram.md) · [📋 Stack & Queue list](./README.md) · [Next: Sliding Window Maximum](./017-sliding-window-maximum.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
