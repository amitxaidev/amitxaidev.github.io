# 10. Brick Wall

**LeetCode 554** · 🟡 Medium · Pattern: **HashMap of edge positions**
🔗 Solve it here: [https://leetcode.com/problems/brick-wall/](https://leetcode.com/problems/brick-wall/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/010-brick-wall.html](https://amitxaidev.github.io/dsa/16-hashing/010-brick-wall.html)

## The problem, in short

A wall is made of rows of bricks of different widths (all rows equally wide). Draw one vertical line top to bottom crossing the fewest bricks; lines along brick edges don't cross them. Return the minimum crossed.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Crossing the fewest bricks = passing through the most edges.

</details>

<details>
<summary>💡 Hint 2</summary>

For every row, record the positions of its internal edges (prefix sums, excluding the wall's right end).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count edge positions across all rows in a HashMap. The answer is rows − (largest count).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edges = new HashMap<>();
        int most = 0;
        for (List<Integer> row : wall) {
            int pos = 0;
            for (int i = 0; i < row.size() - 1; i++) {   // skip the last brick's right edge
                pos += row.get(i);
                most = Math.max(most, edges.merge(pos, 1, Integer::sum));
            }
        }
        return wall.size() - most;
    }
}
```

</details>

## Complexity

- **Time:** O(total bricks).
- **Space:** O(number of distinct edges).

## Common mistake

⚠️ Including the right edge of the wall, which every row shares — it's not allowed.

---

⬅️ [Previous: Max Number of K-Sum Pairs](./009-max-number-of-k-sum-pairs.md) · [📋 Hashing list](./README.md) · [Next: Equal Row and Column Pairs](./011-equal-row-and-column-pairs.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
