# 1. Kth Largest Element in a Stream

**LeetCode 703** · 🟢 Easy · Pattern: **Min-heap of size k**

## The problem, in short

Design a class that receives numbers one by one and, after each one, returns the k-th largest number seen so far.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/kth-largest-element-in-a-stream/](https://leetcode.com/problems/kth-largest-element-in-a-stream/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/001-kth-largest-element-in-a-stream.html](https://amitxaidev.github.io/dsa/21-heaps/001-kth-largest-element-in-a-stream.html)

## Understanding

**Really asking:** after each new number, what's the k-th largest so far?

**Why this works:** keep only the k largest numbers in a min-heap; its smallest (the top) is the k-th largest.

**Example:** k = 3, start [4, 5, 8, 2] → heap {4, 5, 8}
```text
add 3 → {3,4,5,8} → drop 3 → top 4
add 5 → {4,5,5,8} → drop 4 → top 5
add 10 → drop 5 → {5, 8, 10} top 5
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep only the k largest numbers.

</details>

<details>
<summary>💡 Hint 2</summary>

In a min-heap of size k, the smallest of them — the top — is the k-th largest overall.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Add each number to a PriorityQueue; if it grows beyond k, poll the smallest. peek() is the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> heap = new PriorityQueue<>();   // min-heap

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int x : nums) add(x);
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();   // drop the smallest
        return heap.peek();
    }
}
```

</details>

## Complexity

- **Time:** O(log k) per add.
- **Space:** O(k).

## Common mistake

⚠️ Using a max-heap of everything and popping k times on each call.

---

[📋 Heaps & Priority Queue list](./README.md) · [Next: Last Stone Weight](./002-last-stone-weight.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
