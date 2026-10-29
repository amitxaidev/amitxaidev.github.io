# 8. Reorganize String

**LeetCode 767** · 🟡 Medium · Pattern: **Max-heap, place two at a time**
🔗 Solve it here: [https://leetcode.com/problems/reorganize-string/](https://leetcode.com/problems/reorganize-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/008-reorganize-string.html](https://amitxaidev.github.io/dsa/21-heaps/008-reorganize-string.html)

## The problem, in short

Rearrange the letters of a string so no two adjacent letters are equal. Return any valid result, or "" if impossible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

It's impossible if one letter appears more than (n + 1) / 2 times.

</details>

<details>
<summary>💡 Hint 2</summary>

Always place the most frequent remaining letter, but not the same as the last one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Max-heap of (letter, count). Repeatedly poll the top two letters, append both, decrement and push back the ones still left. If one letter remains at the end, append it (its count must be 1).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);   // {letter, count}
        for (int i = 0; i < 26; i++) {
            if (count[i] > (s.length() + 1) / 2) return "";
            if (count[i] > 0) heap.offer(new int[]{i, count[i]});
        }
        StringBuilder sb = new StringBuilder();
        while (heap.size() >= 2) {
            int[] a = heap.poll(), b = heap.poll();      // two different letters
            sb.append((char) ('a' + a[0])).append((char) ('a' + b[0]));
            if (--a[1] > 0) heap.offer(a);
            if (--b[1] > 0) heap.offer(b);
        }
        if (!heap.isEmpty()) sb.append((char) ('a' + heap.poll()[0]));
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(n log 26) = O(n).
- **Space:** O(26).

## Common mistake

⚠️ Polling one letter at a time without holding it back — you may place the same letter twice in a row.

---

⬅️ [Previous: Task Scheduler](./007-task-scheduler.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Kth Smallest Element in a Sorted Matrix](./009-kth-smallest-element-in-a-sorted-matrix.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
