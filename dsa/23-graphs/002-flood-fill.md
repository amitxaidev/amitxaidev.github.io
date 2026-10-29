# 2. Flood Fill

**LeetCode 733** · 🟢 Easy · Pattern: **Grid DFS**
🔗 Solve it here: [https://leetcode.com/problems/flood-fill/](https://leetcode.com/problems/flood-fill/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/002-flood-fill.html](https://amitxaidev.github.io/dsa/23-graphs/002-flood-fill.html)

## The problem, in short

Starting from one pixel, repaint it and every 4-directionally connected pixel of the same original colour with a new colour.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

DFS from the start cell to neighbours with the original colour.

</details>

<details>
<summary>💡 Hint 2</summary>

If the new colour equals the original, return immediately — otherwise you loop forever.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Remember the original colour; recursively recolour matching neighbours. The recolouring itself marks cells as visited.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if (old != color) fill(image, sr, sc, old, color);
        return image;
    }

    private void fill(int[][] img, int r, int c, int old, int color) {
        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length || img[r][c] != old) return;
        img[r][c] = color;   // also marks visited
        fill(img, r + 1, c, old, color);
        fill(img, r - 1, c, old, color);
        fill(img, r, c + 1, old, color);
        fill(img, r, c - 1, old, color);
    }
}
```

</details>

## Complexity

- **Time:** O(m·n).
- **Space:** O(m·n) recursion in the worst case.

## Common mistake

⚠️ Missing the "same colour" early return, which causes infinite recursion.

---

⬅️ [Previous: Find if Path Exists in Graph](./001-find-if-path-exists-in-graph.md) · [📋 Graphs list](./README.md) · [Next: Number of Islands](./003-number-of-islands.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
