# 7. Merge Intervals

**LeetCode 56** · 🟡 Medium · Pattern: **Sort by start**

## The problem, in short

Merge all overlapping intervals and return the non-overlapping result.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/merge-intervals/](https://leetcode.com/problems/merge-intervals/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/007-merge-intervals.html](https://amitxaidev.github.io/dsa/14-sorting/007-merge-intervals.html)

## Understanding

**Really asking:** merge overlapping intervals.

**Why this works:** after sorting by start, an interval either overlaps the last merged one (extend it) or starts a new one.

**Example:** [[1,3],[2,6],[8,10],[15,18]]
```text
[1,3]+[2,6] → [1,6]
[8,10] new, [15,18] new
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort by start time.

</details>

<details>
<summary>💡 Hint 2</summary>

Then each interval either overlaps the last merged one or starts a new one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

After sorting, keep the last merged interval. If the next start &lt;= last end, extend the end with max; otherwise add a new interval.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < cur[0]) {
                res.add(cur);                                   // no overlap
            } else {
                int[] last = res.get(res.size() - 1);
                last[1] = Math.max(last[1], cur[1]);            // extend
            }
        }
        return res.toArray(new int[0][]);
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n) for the output.

## Common mistake

⚠️ Setting end = next.end instead of max(end, next.end) — a nested interval would shrink the merged one.

---

⬅️ [Previous: Largest Number](./006-largest-number.md) · [📋 Sorting list](./README.md) · [Next: Custom Sort String](./008-custom-sort-string.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
