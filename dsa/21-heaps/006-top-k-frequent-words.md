# 6. Top K Frequent Words

**LeetCode 692** · 🟡 Medium · Pattern: **Heap with a two-key comparator**
🔗 Solve it here: [https://leetcode.com/problems/top-k-frequent-words/](https://leetcode.com/problems/top-k-frequent-words/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/006-top-k-frequent-words.html](https://amitxaidev.github.io/dsa/21-heaps/006-top-k-frequent-words.html)

## The problem, in short

Return the k most frequent words, sorted by frequency (high to low) and alphabetically for ties.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count with a HashMap.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a min-heap of size k where the "worst" word is on top: lower frequency, or alphabetically later on ties.

</details>

<details>
<summary>💡 Hint 3</summary>

Pull the heap out and reverse it at the end.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Comparator for the min-heap: frequency ascending, then word descending. Keep size k. Poll everything into a list and reverse.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) freq.merge(w, 1, Integer::sum);
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return Integer.compare(fa, fb);   // less frequent = worse
            return b.compareTo(a);                          // later in alphabet = worse
        });
        for (String w : freq.keySet()) {
            heap.offer(w);
            if (heap.size() > k) heap.poll();
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) res.add(heap.poll());
        Collections.reverse(res);
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n log k).
- **Space:** O(n).

## Common mistake

⚠️ Getting the tie-break backwards inside the min-heap — it must be the reverse of the final order.

---

⬅️ [Previous: K Closest Points to Origin](./005-k-closest-points-to-origin.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: Task Scheduler](./007-task-scheduler.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
