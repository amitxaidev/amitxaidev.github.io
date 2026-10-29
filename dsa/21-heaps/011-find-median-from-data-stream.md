# 11. Find Median from Data Stream

**LeetCode 295** · 🔴 Hard · Pattern: **Two heaps**
🔗 Solve it here: [https://leetcode.com/problems/find-median-from-data-stream/](https://leetcode.com/problems/find-median-from-data-stream/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/011-find-median-from-data-stream.html](https://amitxaidev.github.io/dsa/21-heaps/011-find-median-from-data-stream.html)

## The problem, in short

Design a structure that adds numbers from a stream and returns the median of all numbers so far at any time.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep the smaller half in a max-heap and the larger half in a min-heap.

</details>

<details>
<summary>💡 Hint 2</summary>

Balance them so their sizes differ by at most one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

addNum: push into the max-heap (low), move low's top to the min-heap (high), and if high becomes bigger than low, move high's top back. The median is low's top (odd count) or the average of both tops.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class MedianFinder {
    private final PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());   // max-heap
    private final PriorityQueue<Integer> high = new PriorityQueue<>();                            // min-heap

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());              // largest of the low half moves up
        if (high.size() > low.size()) low.offer(high.poll());   // keep low >= high in size
    }

    public double findMedian() {
        if (low.size() > high.size()) return low.peek();
        return (low.peek() + (double) high.peek()) / 2;
    }
}
```

</details>

## Complexity

- **Time:** O(log n) add, O(1) median.
- **Space:** O(n).

## Common mistake

⚠️ Adding to one heap based only on size and not passing through the other heap — the halves can end up out of order.

---

⬅️ [Previous: Furthest Building You Can Reach](./010-furthest-building-you-can-reach.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: IPO](./012-ipo.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
