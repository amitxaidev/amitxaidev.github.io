# 8. Triangle

**LeetCode 120** · 🟡 Medium · Pattern: **Bottom-up DP**
🔗 Solve it here: [https://leetcode.com/problems/triangle/](https://leetcode.com/problems/triangle/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/008-triangle.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/008-triangle.html)

## The problem, in short

Find the minimum path sum from the top to the bottom of a number triangle, moving to an adjacent number on the row below each step.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Going top-down needs care at the edges. Go bottom-up instead.

</details>

<details>
<summary>💡 Hint 2</summary>

best[i] on a row = value + min(best[i], best[i + 1]) of the row below.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Start with a copy of the last row. Move up row by row, updating in place. The answer ends in best[0].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] best = new int[n + 1];   // row below the last row = zeros
        for (int r = n - 1; r >= 0; r--) {
            for (int i = 0; i <= r; i++) {
                best[i] = triangle.get(r).get(i) + Math.min(best[i], best[i + 1]);
            }
        }
        return best[0];
    }
}
```

</details>

## Complexity

- **Time:** O(n²) for n rows.
- **Space:** O(n).

## Common mistake

⚠️ Greedily picking the smaller child at each step.

---

⬅️ [Previous: Minimum Path Sum](./007-minimum-path-sum.md) · [📋 Dynamic Programming list](./README.md) · [Next: Partition Equal Subset Sum](./009-partition-equal-subset-sum.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
