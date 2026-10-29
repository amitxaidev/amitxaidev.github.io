# 10. Game of Life

**LeetCode 289** · 🟡 Medium · Pattern: **In-place state encoding**

## The problem, in short

Compute the next generation of Conway's Game of Life on a grid, in place. All cells update at the same time based on their eight neighbours.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/game-of-life/](https://leetcode.com/problems/game-of-life/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/010-game-of-life.html](https://amitxaidev.github.io/dsa/10-matrix/010-game-of-life.html)

## Understanding

**Really asking:** compute the next generation, where every cell updates at the same time.

**Why this works:** keep the old state in bit 0 and write the new state into bit 1. Neighbours read bit 0 only; at the end shift every cell right.

**Example:** live cell with 1 live neighbour
```text
old bit 1, dies → new bit 0 → value stays 01
after shifting → 0 (dead)
```

## Hints

<details>
<summary>💡 Hint 1</summary>

You need the old state of neighbours even after you've updated them.

</details>

<details>
<summary>💡 Hint 2</summary>

Store the new state in the second bit: cell |= (newState &lt;&lt; 1).

</details>

<details>
<summary>💡 Hint 3</summary>

After the pass, shift every cell right by one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each cell count live neighbours using only bit 0 (the old state). Decide the next state (live with 2 or 3 neighbours, dead with exactly 3 becomes live) and set bit 1. Finally replace each cell with its bit 1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;
                for (int dr = -1; dr <= 1; dr++)
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        int rr = r + dr, cc = c + dc;
                        if (rr >= 0 && rr < m && cc >= 0 && cc < n) live += board[rr][cc] & 1;   // old state only
                    }
                boolean alive = (board[r][c] & 1) == 1;
                if ((alive && (live == 2 || live == 3)) || (!alive && live == 3)) board[r][c] |= 2;
            }
        }
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++) board[r][c] >>= 1;   // new state becomes current
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(1).

## Common mistake

⚠️ Updating cells directly, so later cells see a mix of old and new neighbours.

---

⬅️ [Previous: Valid Sudoku](./009-valid-sudoku.md) · [📋 2D Arrays & Matrix list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
