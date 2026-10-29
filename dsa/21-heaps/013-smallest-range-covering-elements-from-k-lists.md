# 13. Smallest Range Covering Elements from K Lists

**LeetCode 632** · 🔴 Hard · Pattern: **Min-heap with running max**

## The problem, in short

Given k sorted lists, find the smallest range [a, b] that includes at least one number from each list (ties: the one with the smaller a).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/013-smallest-range-covering-elements-from-k-lists.html](https://amitxaidev.github.io/dsa/21-heaps/013-smallest-range-covering-elements-from-k-lists.html)

## Understanding

**Really asking:** the narrowest range containing at least one number from every list.

**Why this works:** hold one pointer per list. The range is [min, max] of the pointed values; only advancing the list with the minimum can make it narrower.

**Example:** [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
```text
start {4, 0, 5} → [0, 5]
… best found [20, 24]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Hold one pointer per list. The range is [min of pointed values, max of pointed values].

</details>

<details>
<summary>💡 Hint 2</summary>

To shrink it, only advancing the list with the minimum can help.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Min-heap of (value, list, index) starting with each list's first element; track the current max. Each step: record the range if better, poll the min, and push the next element of that list (updating max). Stop when a list runs out.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));   // {value, list, idx}
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int v = nums.get(i).get(0);
            heap.offer(new int[]{v, i, 0});
            max = Math.max(max, v);
        }
        int bestLo = 0, bestHi = Integer.MAX_VALUE;
        while (true) {
            int[] top = heap.poll();
            if ((long) max - top[0] < (long) bestHi - bestLo) {
                bestLo = top[0];
                bestHi = max;
            }
            List<Integer> list = nums.get(top[1]);
            if (top[2] + 1 == list.size()) break;   // this list is exhausted
            int next = list.get(top[2] + 1);
            heap.offer(new int[]{next, top[1], top[2] + 1});
            max = Math.max(max, next);
        }
        return new int[]{bestLo, bestHi};
    }
}
```

</details>

## Complexity

- **Time:** O(N log k), N = total elements.
- **Space:** O(k).

## Common mistake

⚠️ Advancing the list with the maximum — that can only widen the range.

---

⬅️ [Previous: IPO](./012-ipo.md) · [📋 Heaps & Priority Queue list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
