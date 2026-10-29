# 3. Number of Islands

**LeetCode 200** · 🟡 Medium · Pattern: **Connected components on a grid**

## The problem, in short

In a grid of '1' (land) and '0' (water), count islands — groups of land connected up/down/left/right.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/number-of-islands/](https://leetcode.com/problems/number-of-islands/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/003-number-of-islands.html](https://amitxaidev.github.io/dsa/23-graphs/003-number-of-islands.html)

## Understanding

**Really asking:** how many separate groups of land?

**Why this works:** each time you find new land, count one island and sink the whole island with DFS so it isn't counted again.

**Example:** 1 1 0 / 0 1 0 / 0 0 1
```text
first island: top-left 3 cells
second island: bottom-right cell → 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Each time you find unvisited land, that's a new island.

</details>

<details>
<summary>💡 Hint 2</summary>

Sink the whole island with DFS/BFS so you don't count it again.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan cells. On a '1', increment the count and DFS to set every connected '1' to '0'.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
        return count;
    }

    private void sink(char[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != '1') return;
        g[r][c] = '0';   // visited
        sink(g, r + 1, c);
        sink(g, r - 1, c);
        sink(g, r, c + 1);
        sink(g, r, c - 1);
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(m·n) worst-case recursion.

## Common mistake

⚠️ Counting diagonal neighbours as connected.

---

⬅️ [Previous: Flood Fill](./002-flood-fill.md) · [📋 Graphs list](./README.md) · [Next: Number of Provinces](./004-number-of-provinces.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
