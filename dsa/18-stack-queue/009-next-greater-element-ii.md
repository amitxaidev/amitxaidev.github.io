# 9. Next Greater Element II

**LeetCode 503** · 🟡 Medium · Pattern: **Monotonic stack, circular**
🔗 Solve it here: [https://leetcode.com/problems/next-greater-element-ii/](https://leetcode.com/problems/next-greater-element-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/009-next-greater-element-ii.html](https://amitxaidev.github.io/dsa/18-stack-queue/009-next-greater-element-ii.html)

## The problem, in short

The array is circular. For each element, return the next greater element when searching forward (wrapping around), or -1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Loop through the array twice (indexes 0..2n−1, using i % n).

</details>

<details>
<summary>💡 Hint 2</summary>

Only push indexes during the first pass.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill answers with -1. For i in 0..2n−1, let x = nums[i % n]; pop every index whose value is smaller than x and set its answer to x. Push i only when i &lt; n.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < x) ans[stack.pop()] = x;
            if (i < n) stack.push(i);   // second lap only answers, never waits
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Pushing during the second pass too, which can record wrong answers and wastes work.

---

⬅️ [Previous: Daily Temperatures](./008-daily-temperatures.md) · [📋 Stack & Queue list](./README.md) · [Next: Online Stock Span](./010-online-stock-span.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
