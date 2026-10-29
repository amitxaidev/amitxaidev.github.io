# 10. Furthest Building You Can Reach

**LeetCode 1642** · 🟡 Medium · Pattern: **Min-heap of climbs given ladders**
🔗 Solve it here: [https://leetcode.com/problems/furthest-building-you-can-reach/](https://leetcode.com/problems/furthest-building-you-can-reach/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/010-furthest-building-you-can-reach.html](https://amitxaidev.github.io/dsa/21-heaps/010-furthest-building-you-can-reach.html)

## The problem, in short

Walk past buildings left to right. Climbing up costs bricks equal to the height difference, or one ladder. Return the furthest building index you can reach.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Ladders are best used on the biggest climbs.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep the climbs you've used ladders on in a min-heap. When you run out of ladders, pay bricks for the smallest of them.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each positive climb, push it into a min-heap. If the heap has more entries than ladders, poll the smallest and spend bricks on it. If bricks go negative, you can't reach this building — return i.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderClimbs = new PriorityQueue<>();   // min-heap
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) continue;
            ladderClimbs.offer(climb);
            if (ladderClimbs.size() > ladders) {
                bricks -= ladderClimbs.poll();   // smallest climb gets bricks instead
                if (bricks < 0) return i;
            }
        }
        return heights.length - 1;
    }
}
```

</details>

## Complexity

- **Time:** O(n log L), L = ladders.
- **Space:** O(L).

## Common mistake

⚠️ Greedily using bricks first and ladders when bricks run out — that wastes ladders on small climbs.

---

⬅️ [Previous: Kth Smallest Element in a Sorted Matrix](./009-kth-smallest-element-in-a-sorted-matrix.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Find Median from Data Stream](./011-find-median-from-data-stream.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
