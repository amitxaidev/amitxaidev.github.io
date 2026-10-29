# 4. Next Greater Element I

**LeetCode 496** · 🟢 Easy · Pattern: **Monotonic stack**

## The problem, in short

nums1 is a subset of nums2. For each value in nums1, find the first greater value to its right in nums2, or -1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/next-greater-element-i/](https://leetcode.com/problems/next-greater-element-i/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/004-next-greater-element-i.html](https://amitxaidev.github.io/dsa/18-stack-queue/004-next-greater-element-i.html)

## Understanding

**Really asking:** for each value, the first bigger value to its right.

**Why this works:** keep a stack of values still waiting; a bigger value pops them all and becomes their answer.

**Example:** nums2 [1, 3, 4, 2]
```text
1 waits, 3 answers 1, 4 answers 3, 2 waits
next: 1→3, 3→4, 4→-1, 2→-1
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Compute "next greater" for every value of nums2 once.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a stack of values still waiting for a greater one; it stays decreasing.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan nums2. While the current value is bigger than the stack's top, that top's answer is the current value — record it in a map and pop. Push the current value. Then answer nums1 from the map.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : nums2) {
            while (!stack.isEmpty() && stack.peek() < x) next.put(stack.pop(), x);   // x answers them
            stack.push(x);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = next.getOrDefault(nums1[i], -1);
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(n).

## Common mistake

⚠️ For each element, scanning to the right — O(n²).

---

⬅️ [Previous: Implement Stack using Queues](./003-implement-stack-using-queues.md) · [📋 Stack & Queue list](./README.md) · [Next: Backspace String Compare](./005-backspace-string-compare.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
