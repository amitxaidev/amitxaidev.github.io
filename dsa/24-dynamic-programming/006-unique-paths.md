# 6. Unique Paths

**LeetCode 62** · 🟡 Medium · Pattern: **2D grid DP**
🔗 Solve it here: [https://leetcode.com/problems/unique-paths/](https://leetcode.com/problems/unique-paths/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/006-unique-paths.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/006-unique-paths.html)

## The problem, in short

A robot at the top-left of an m × n grid moves only right or down. Count the paths to the bottom-right.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Paths to a cell = paths to the cell above + paths to the cell on the left.

</details>

<details>
<summary>💡 Hint 2</summary>

The first row and first column have exactly one path each.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep one row array; dp[c] += dp[c − 1] row by row, which adds "from above" (old dp[c]) and "from left" (new dp[c − 1]).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);                 // first row
        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                dp[c] += dp[c - 1];         // from above + from left
        return dp[n - 1];
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(n).

## Common mistake

⚠️ Using int for the combinatorial formula C(m+n−2, m−1) without care — intermediate products overflow.

---

⬅️ [Previous: House Robber II](./005-house-robber-ii.md) · [📋 Dynamic Programming list](./README.md) · [Next: Minimum Path Sum](./007-minimum-path-sum.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
