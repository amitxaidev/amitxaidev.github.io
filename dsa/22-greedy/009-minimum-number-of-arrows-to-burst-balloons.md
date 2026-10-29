# 9. Minimum Number of Arrows to Burst Balloons

**LeetCode 452** · 🟡 Medium · Pattern: **Sort by end**

## The problem, in short

Balloons span intervals on the x-axis. A vertical arrow at x bursts every balloon whose interval contains x (ends included). Return the fewest arrows needed.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/009-minimum-number-of-arrows-to-burst-balloons.html](https://amitxaidev.github.io/dsa/22-greedy/009-minimum-number-of-arrows-to-burst-balloons.html)

## Understanding

**Really asking:** fewest arrows to pop all balloons.

**Why this works:** shoot at the end of the earliest-ending balloon; it pops every balloon that has already started.

**Example:** [[10,16],[2,8],[1,6],[7,12]] sorted by end
```text
arrow at 6 pops [1,6], [2,8]
arrow at 12 pops [7,12], [10,16] → 2 arrows
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Shoot each arrow as far right as possible: at the end of the earliest-ending balloon.

</details>

<details>
<summary>💡 Hint 2</summary>

That arrow also bursts every balloon that starts at or before that point.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sort by end. Shoot at the first end; skip balloons with start &lt;= arrow; on the first balloon starting after the arrow, shoot again at its end.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        long arrow = points[0][1];
        for (int[] p : points) {
            if (p[0] > arrow) {      // not hit by the current arrow
                arrows++;
                arrow = p[1];
            }
        }
        return arrows;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(log n).

## Common mistake

⚠️ Comparator a[1] − b[1] overflows with values near ±2^31. Use Integer.compare.

---

⬅️ [Previous: Non-overlapping Intervals](./008-non-overlapping-intervals.md) · [📋 Greedy list](./README.md) · [Next: Insert Interval](./010-insert-interval.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
