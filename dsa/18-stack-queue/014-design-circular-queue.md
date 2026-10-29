# 14. Design Circular Queue

**LeetCode 622** · 🟡 Medium · Pattern: **Array ring buffer**
🔗 Solve it here: [https://leetcode.com/problems/design-circular-queue/](https://leetcode.com/problems/design-circular-queue/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/014-design-circular-queue.html](https://amitxaidev.github.io/dsa/18-stack-queue/014-design-circular-queue.html)

## The problem, in short

Implement a fixed-size circular queue with enQueue, deQueue, Front, Rear, isEmpty and isFull.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Use an array, a head index and a count.

</details>

<details>
<summary>💡 Hint 2</summary>

The tail index is (head + count) % capacity.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

enQueue writes at (head + count) % cap and increments count. deQueue moves head forward with % cap and decrements count. Rear is at (head + count − 1) % cap.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class MyCircularQueue {
    private final int[] data;
    private int head = 0, count = 0;

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[(head + count) % data.length] = value;   // wrap around
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % data.length;
        count--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[(head + count - 1) % data.length];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }
}
```

</details>

## Complexity

- **Time:** O(1) per operation.
- **Space:** O(k).

## Common mistake

⚠️ Tracking only head and tail without a count — empty and full look the same.

---

⬅️ [Previous: Sum of Subarray Minimums](./013-sum-of-subarray-minimums.md) · [📋 Stack & Queue list](./README.md) · [Next: Largest Rectangle in Histogram](./015-largest-rectangle-in-histogram.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
