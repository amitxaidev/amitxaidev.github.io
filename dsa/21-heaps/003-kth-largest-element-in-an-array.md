# 3. Kth Largest Element in an Array

**LeetCode 215** · 🟡 Medium · Pattern: **Min-heap / quickselect**

## The problem, in short

Return the k-th largest element of an unsorted array (by sorted position, so duplicates count).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/kth-largest-element-in-an-array/](https://leetcode.com/problems/kth-largest-element-in-an-array/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/003-kth-largest-element-in-an-array.html](https://amitxaidev.github.io/dsa/21-heaps/003-kth-largest-element-in-an-array.html)

## Understanding

**Really asking:** the k-th largest value in an unsorted array.

**Why this works:** a min-heap of size k keeps the k largest; its top is the answer.

**Example:** [3, 2, 1, 5, 6, 4], k = 2
```text
heap ends as {5, 6} → top 5
```

## Hints

<details>
<summary>💡 Hint 1</summary>

A min-heap of size k gives O(n log k).

</details>

<details>
<summary>💡 Hint 2</summary>

Quickselect partitions like quicksort but recurses into one side only: average O(n).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a min-heap of at most k elements; after scanning, its top is the answer. (Quickselect is the follow-up; use a random pivot to avoid worst cases.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : nums) {
            heap.offer(x);
            if (heap.size() > k) heap.poll();   // keep the k largest
        }
        return heap.peek();
    }
}
```

</details>

## Complexity

- **Time:** O(n log k).
- **Space:** O(k).

## Common mistake

⚠️ Treating it as "k-th largest distinct value" and removing duplicates.

---

⬅️ [Previous: Last Stone Weight](./002-last-stone-weight.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Top K Frequent Elements](./004-top-k-frequent-elements.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
