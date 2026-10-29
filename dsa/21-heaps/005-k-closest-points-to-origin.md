# 5. K Closest Points to Origin

**LeetCode 973** · 🟡 Medium · Pattern: **Max-heap of size k**
🔗 Solve it here: [https://leetcode.com/problems/k-closest-points-to-origin/](https://leetcode.com/problems/k-closest-points-to-origin/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/005-k-closest-points-to-origin.html](https://amitxaidev.github.io/dsa/21-heaps/005-k-closest-points-to-origin.html)

## The problem, in short

Return the k points closest to (0, 0), in any order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compare squared distances — no need for square roots.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a max-heap of the k closest so far; evict the farthest when it grows past k.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Push each point into a max-heap ordered by x² + y². Poll when the size exceeds k. The heap holds the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(dist(b), dist(a)));   // farthest on top
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k) heap.poll();
        }
        return heap.toArray(new int[0][]);
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
```

</details>

## Complexity

- **Time:** O(n log k).
- **Space:** O(k).

## Common mistake

⚠️ Using a min-heap of all n points and polling k times — O(n log n), more memory.

---

⬅️ [Previous: Top K Frequent Elements](./004-top-k-frequent-elements.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Top K Frequent Words](./006-top-k-frequent-words.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
