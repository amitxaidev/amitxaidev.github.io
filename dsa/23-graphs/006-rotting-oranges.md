# 6. Rotting Oranges

**LeetCode 994** · 🟡 Medium · Pattern: **Multi-source BFS**

## The problem, in short

Every minute, rotten oranges rot their fresh 4-directional neighbours. Return the minutes until no fresh orange is left, or -1 if that never happens.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/rotting-oranges/](https://leetcode.com/problems/rotting-oranges/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/006-rotting-oranges.html](https://amitxaidev.github.io/dsa/23-graphs/006-rotting-oranges.html)

## Understanding

**Really asking:** minutes until every orange is rotten, or -1.

**Why this works:** all rotten oranges spread at once, so start BFS from all of them together; each BFS level is one minute.

**Example:** 2 1 1 / 1 1 0 / 0 1 1
```text
minute 1, 2, 3, 4 → all rotten → 4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

All rotten oranges spread at the same time — start BFS from all of them at once.

</details>

<details>
<summary>💡 Hint 2</summary>

Each BFS level is one minute. Count fresh oranges to know if any remain.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Queue all rotten cells and count fresh ones. Process level by level, rotting fresh neighbours and decrementing the fresh count. Minutes = levels processed while something rotted.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) q.offer(new int[]{r, c});   // all sources at once
                else if (grid[r][c] == 1) fresh++;
            }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            for (int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                for (int[] d : dirs) {
                    int r = cell[0] + d[0], c = cell[1] + d[1];
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(m·n).

## Common mistake

⚠️ Running a separate BFS from each rotten orange — wrong timing and slower.

---

⬅️ [Previous: Max Area of Island](./005-max-area-of-island.md) · [📋 Graphs list](./README.md) · [Next: Pacific Atlantic Water Flow](./007-pacific-atlantic-water-flow.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
