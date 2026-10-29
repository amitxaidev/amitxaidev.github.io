# 5. Falling Squares

**LeetCode 699** · 🔴 Hard · Pattern: **Segment tree with range assign / range max**
🔗 Solve it here: [https://leetcode.com/problems/falling-squares/](https://leetcode.com/problems/falling-squares/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/26-segment-fenwick/005-falling-squares.html](https://amitxaidev.github.io/dsa/26-segment-fenwick/005-falling-squares.html)

## The problem, in short

Squares fall one by one onto a line; each lands on top of the highest square under its span. After each drop, report the tallest stack height so far.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You need "max height over [left, right)" and "set every height in [left, right) to h".

</details>

<details>
<summary>💡 Hint 2</summary>

Coordinate-compress the edges, then use a segment tree with lazy assignment.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Collect all lefts and rights, sort and compress. For each square: h = query max over its compressed range + side; assign h to that range; the answer is the running maximum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private int[] mx, lazy;

    public List<Integer> fallingSquares(int[][] positions) {
        TreeSet<Integer> coords = new TreeSet<>();
        for (int[] p : positions) {
            coords.add(p[0]);
            coords.add(p[0] + p[1] - 1);          // last occupied unit
        }
        Map<Integer, Integer> id = new HashMap<>();
        for (int c : coords) id.put(c, id.size());
        int n = id.size();
        mx = new int[4 * n];
        lazy = new int[4 * n];
        List<Integer> res = new ArrayList<>();
        int best = 0;
        for (int[] p : positions) {
            int l = id.get(p[0]), r = id.get(p[0] + p[1] - 1);
            int h = query(1, 0, n - 1, l, r) + p[1];
            assign(1, 0, n - 1, l, r, h);
            best = Math.max(best, h);
            res.add(best);
        }
        return res;
    }

    private void push(int node) {
        if (lazy[node] != 0) {
            for (int c : new int[]{2 * node, 2 * node + 1}) {
                mx[c] = lazy[node];
                lazy[c] = lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private void assign(int node, int lo, int hi, int l, int r, int h) {
        if (r < lo || hi < l) return;
        if (l <= lo && hi <= r) {                 // fully covered: set lazily
            mx[node] = h;
            lazy[node] = h;
            return;
        }
        push(node);
        int mid = (lo + hi) / 2;
        assign(2 * node, lo, mid, l, r, h);
        assign(2 * node + 1, mid + 1, hi, l, r, h);
        mx[node] = Math.max(mx[2 * node], mx[2 * node + 1]);
    }

    private int query(int node, int lo, int hi, int l, int r) {
        if (r < lo || hi < l) return 0;
        if (l <= lo && hi <= r) return mx[node];
        push(node);
        int mid = (lo + hi) / 2;
        return Math.max(query(2 * node, lo, mid, l, r), query(2 * node + 1, mid + 1, hi, l, r));
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Treating the right edge as occupied — squares touching at an edge don't stack, so use the half-open range [left, left + side).

---

⬅️ [Previous: Create Sorted Array through Instructions](./004-create-sorted-array-through-instructions.md) · [📋 Segment Tree, Fenwick & Sparse Table list](./README.md) · [Next: Longest Increasing Subsequence II](./006-longest-increasing-subsequence-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
