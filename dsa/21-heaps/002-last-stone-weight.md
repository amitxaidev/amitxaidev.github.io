# 2. Last Stone Weight

**LeetCode 1046** · 🟢 Easy · Pattern: **Max-heap simulation**
🔗 Solve it here: [https://leetcode.com/problems/last-stone-weight/](https://leetcode.com/problems/last-stone-weight/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/002-last-stone-weight.html](https://amitxaidev.github.io/dsa/21-heaps/002-last-stone-weight.html)

## The problem, in short

Repeatedly smash the two heaviest stones: equal weights destroy both, otherwise the heavier one loses the lighter one's weight. Return the last stone's weight, or 0.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You always need the two largest values — a max-heap.

</details>

<details>
<summary>💡 Hint 2</summary>

Push back the difference if it's not zero.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Put all stones in a max-heap (Collections.reverseOrder()). While at least two remain, poll two and push back their difference if positive.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) heap.offer(s);
        while (heap.size() > 1) {
            int y = heap.poll(), x = heap.poll();   // two heaviest
            if (y != x) heap.offer(y - x);
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Sorting the array again after every smash — O(n² log n).

---

⬅️ [Previous: Kth Largest Element in a Stream](./001-kth-largest-element-in-a-stream.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Kth Largest Element in an Array](./003-kth-largest-element-in-an-array.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
