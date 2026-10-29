# 9. Kth Smallest Element in a Sorted Matrix

**LeetCode 378** · 🟡 Medium · Pattern: **K-way merge with a min-heap**
🔗 Solve it here: [https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/009-kth-smallest-element-in-a-sorted-matrix.html](https://amitxaidev.github.io/dsa/21-heaps/009-kth-smallest-element-in-a-sorted-matrix.html)

## The problem, in short

In an n×n matrix where every row and column is sorted ascending, return the k-th smallest element.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Each row is a sorted list — merge them like "Merge k Sorted Lists".

</details>

<details>
<summary>💡 Hint 2</summary>

Start with the first element of each row in a min-heap; pop k − 1 times, pushing the next element of the popped row.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Heap entries are (value, row, col). After k − 1 pops (each followed by pushing the next column of that row), the top is the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int r = 0; r < Math.min(n, k); r++) heap.offer(new int[]{matrix[r][0], r, 0});
        for (int i = 0; i < k - 1; i++) {
            int[] top = heap.poll();
            int r = top[1], c = top[2];
            if (c + 1 < n) heap.offer(new int[]{matrix[r][c + 1], r, c + 1});   // next in that row
        }
        return heap.peek()[0];
    }
}
```

</details>

## Complexity

- **Time:** O(k log n).
- **Space:** O(n).

## Common mistake

⚠️ Flattening and sorting — O(n² log n), ignores the sorted structure. (Binary search on value is another good approach.)

---

⬅️ [Previous: Reorganize String](./008-reorganize-string.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Furthest Building You Can Reach](./010-furthest-building-you-can-reach.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
