# 11. Equal Row and Column Pairs

**LeetCode 2352** · 🟡 Medium · Pattern: **HashMap of row signatures**
🔗 Solve it here: [https://leetcode.com/problems/equal-row-and-column-pairs/](https://leetcode.com/problems/equal-row-and-column-pairs/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/011-equal-row-and-column-pairs.html](https://amitxaidev.github.io/dsa/16-hashing/011-equal-row-and-column-pairs.html)

## The problem, in short

In an n×n grid, count pairs (row r, column c) where the row and the column contain the same values in the same order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Turn each row into a key (e.g. its values joined into a string).

</details>

<details>
<summary>💡 Hint 2</summary>

Count row keys in a map, then build each column's key and look it up.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Store counts of row signatures, then for every column build its signature and add the matching row count.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rows = new HashMap<>();
        for (int[] row : grid) rows.merge(Arrays.toString(row), 1, Integer::sum);
        int pairs = 0;
        for (int c = 0; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++) col[r] = grid[r][c];
            pairs += rows.getOrDefault(Arrays.toString(col), 0);
        }
        return pairs;
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(n²).

## Common mistake

⚠️ Using int[] as a map key — arrays use identity, so equal rows don't match. Use Arrays.toString or a List.

---

⬅️ [Previous: Brick Wall](./010-brick-wall.md) · [📋 Hashing list](./README.md) · [Next: Max Points on a Line](./012-max-points-on-a-line.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
