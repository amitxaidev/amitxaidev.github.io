# 10. Insert Interval

**LeetCode 57** · 🟡 Medium · Pattern: **Three phases**
🔗 Solve it here: [https://leetcode.com/problems/insert-interval/](https://leetcode.com/problems/insert-interval/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/010-insert-interval.html](https://amitxaidev.github.io/dsa/22-greedy/010-insert-interval.html)

## The problem, in short

Insert a new interval into a sorted list of non-overlapping intervals, merging where needed.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Intervals ending before the new one starts are untouched.

</details>

<details>
<summary>💡 Hint 2</summary>

Intervals overlapping it get merged into it.

</details>

<details>
<summary>💡 Hint 3</summary>

The rest come after.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass in three phases: copy intervals that end before newStart, merge overlapping ones by expanding newInterval's start and end, add it, then copy the remaining.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        int start = newInterval[0], end = newInterval[1];
        while (i < n && intervals[i][1] < start) res.add(intervals[i++]);   // before
        while (i < n && intervals[i][0] <= end) {                           // overlapping
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});
        while (i < n) res.add(intervals[i++]);                              // after
        return res.toArray(new int[0][]);
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Using &lt; vs &lt;= wrongly — intervals that touch (end == start) should merge.

---

⬅️ [Previous: Minimum Number of Arrows to Burst Balloons](./009-minimum-number-of-arrows-to-burst-balloons.md) · [📋 Greedy list](./README.md) · [Next: Partition Labels](./011-partition-labels.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
