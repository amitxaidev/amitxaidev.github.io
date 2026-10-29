# 7. Task Scheduler

**LeetCode 621** · 🟡 Medium · Pattern: **Greedy counting**
🔗 Solve it here: [https://leetcode.com/problems/task-scheduler/](https://leetcode.com/problems/task-scheduler/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/007-task-scheduler.html](https://amitxaidev.github.io/dsa/21-heaps/007-task-scheduler.html)

## The problem, in short

CPU tasks are letters; the same letter needs at least n intervals between runs. Each interval runs one task or idles. Return the minimum number of intervals.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The most frequent task decides the frame: (maxCount − 1) gaps of size n + 1, plus a last row.

</details>

<details>
<summary>💡 Hint 2</summary>

The last row holds every task that ties for the maximum count.

</details>

<details>
<summary>💡 Hint 3</summary>

If there are more tasks than the frame has slots, no idling is needed: the answer is the task count.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Answer = max(tasks.length, (maxCount − 1) × (n + 1) + numberOfTasksWithMaxCount). (A max-heap simulation also works and is good practice.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        for (char t : tasks) max = Math.max(max, ++count[t - 'A']);
        int maxCount = 0;
        for (int c : count) if (c == max) maxCount++;
        int frame = (max - 1) * (n + 1) + maxCount;   // most frequent task sets the frame
        return Math.max(tasks.length, frame);
    }
}
```

</details>

## Complexity

- **Time:** O(m), m = number of tasks.
- **Space:** O(26).

## Common mistake

⚠️ Forgetting the max with tasks.length, which gives too small an answer when there's no idle time.

---

⬅️ [Previous: Top K Frequent Words](./006-top-k-frequent-words.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Reorganize String](./008-reorganize-string.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
