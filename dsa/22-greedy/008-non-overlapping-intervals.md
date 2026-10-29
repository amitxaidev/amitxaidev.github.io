# 8. Non-overlapping Intervals

**LeetCode 435** · 🟡 Medium · Pattern: **Sort by end (activity selection)**
🔗 Solve it here: [https://leetcode.com/problems/non-overlapping-intervals/](https://leetcode.com/problems/non-overlapping-intervals/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/008-non-overlapping-intervals.html](https://amitxaidev.github.io/dsa/22-greedy/008-non-overlapping-intervals.html)

## The problem, in short

Return the minimum number of intervals to remove so the rest don't overlap (touching ends are fine).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Equivalent: keep as many non-overlapping intervals as possible.

</details>

<details>
<summary>💡 Hint 2</summary>

Activity selection: always keep the interval that ends earliest.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sort by end. Keep the first; for each next interval, keep it if its start >= last kept end, otherwise remove it. Answer = number removed.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));   // earliest end first
        int removed = 0, end = Integer.MIN_VALUE;
        for (int[] iv : intervals) {
            if (iv[0] >= end) end = iv[1];   // keep it
            else removed++;
        }
        return removed;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(log n).

## Common mistake

⚠️ Sorting by start and keeping the first — a long early interval can block many short ones.

---

⬅️ [Previous: Gas Station](./007-gas-station.md) · [📋 Greedy list](./README.md) · [Next: Minimum Number of Arrows to Burst Balloons](./009-minimum-number-of-arrows-to-burst-balloons.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
