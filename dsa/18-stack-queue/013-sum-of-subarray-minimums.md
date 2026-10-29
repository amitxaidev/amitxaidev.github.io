# 13. Sum of Subarray Minimums

**LeetCode 907** · 🟡 Medium · Pattern: **Monotonic stack contribution**
🔗 Solve it here: [https://leetcode.com/problems/sum-of-subarray-minimums/](https://leetcode.com/problems/sum-of-subarray-minimums/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/013-sum-of-subarray-minimums.html](https://amitxaidev.github.io/dsa/18-stack-queue/013-sum-of-subarray-minimums.html)

## The problem, in short

Sum the minimum of every contiguous subarray, modulo 1e9+7.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Instead of looping over subarrays, ask: in how many subarrays is arr[i] the minimum?

</details>

<details>
<summary>💡 Hint 2</summary>

That's (distance to the previous smaller element) × (distance to the next smaller-or-equal element).

</details>

<details>
<summary>💡 Hint 3</summary>

Use strict on one side and non-strict on the other so equal values aren't counted twice.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Use a monotonic increasing stack. When an index is popped by a smaller-or-equal value at i, its next boundary is i and its previous boundary is the new stack top. Add arr[mid] × left × right. A sentinel pass at i = n flushes the stack.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        final long MOD = 1_000_000_007L;
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? Integer.MIN_VALUE : arr[i];   // sentinel flushes the stack
            while (!st.isEmpty() && arr[st.peek()] >= cur) {
                int mid = st.pop();
                int left = mid - (st.isEmpty() ? -1 : st.peek());   // choices for the start
                int right = i - mid;                                // choices for the end
                sum = (sum + (long) arr[mid] * left * right) % MOD;
            }
            st.push(i);
        }
        return (int) sum;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Using strict &lt; on both sides, which double-counts subarrays with repeated minimums.

---

⬅️ [Previous: Remove K Digits](./012-remove-k-digits.md) · [📋 Stack & Queue list](./README.md) · [Next: Design Circular Queue](./014-design-circular-queue.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
