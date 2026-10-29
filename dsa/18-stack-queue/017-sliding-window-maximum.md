# 17. Sliding Window Maximum

**LeetCode 239** · 🔴 Hard · Pattern: **Monotonic deque**

## The problem, in short

For every window of size k sliding across the array, return the maximum.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sliding-window-maximum/](https://leetcode.com/problems/sliding-window-maximum/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/017-sliding-window-maximum.html](https://amitxaidev.github.io/dsa/18-stack-queue/017-sliding-window-maximum.html)

## Understanding

**Really asking:** the maximum of every window of size k.

**Why this works:** a deque of indexes with decreasing values. The front is the max; drop it when it leaves the window, and drop smaller values from the back.

**Example:** [1, 3, -1, -3, 5, 3, 6, 7], k = 3
```text
maxima: 3, 3, 5, 5, 6, 7
```

## Hints

<details>
<summary>💡 Hint 1</summary>

A heap works in O(n log n). Can you do O(n)?

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a deque of indexes whose values are decreasing from front to back.

</details>

<details>
<summary>💡 Hint 3</summary>

The front is the current maximum; drop it when it leaves the window.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each i: remove the front if it's out of the window (i − k). Remove from the back while the back's value &lt;= nums[i] — those can never be a maximum again. Add i. Once i >= k − 1, record nums[front].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();   // indexes, values decreasing
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();        // left the window
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();   // useless now
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(k).

## Common mistake

⚠️ Storing values instead of indexes, so you can't tell when the front has left the window.

---

⬅️ [Previous: Maximal Rectangle](./016-maximal-rectangle.md) · [📋 Stack & Queue list](./README.md) · [Next: Basic Calculator](./018-basic-calculator.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
