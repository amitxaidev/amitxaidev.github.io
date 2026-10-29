# 4. Top K Frequent Elements

**LeetCode 347** · 🟡 Medium · Pattern: **Bucket sort by frequency**
🔗 Solve it here: [https://leetcode.com/problems/top-k-frequent-elements/](https://leetcode.com/problems/top-k-frequent-elements/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/21-heaps/004-top-k-frequent-elements.html](https://amitxaidev.github.io/dsa/21-heaps/004-top-k-frequent-elements.html)

## The problem, in short

Return the k most frequent values in the array (the answer is unique).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count frequencies with a HashMap.

</details>

<details>
<summary>💡 Hint 2</summary>

A min-heap of size k on frequency gives O(n log k).

</details>

<details>
<summary>💡 Hint 3</summary>

Frequencies are between 1 and n, so buckets indexed by frequency give O(n).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count, then put each value in bucket[freq]. Walk buckets from n down and collect values until you have k.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) buckets.get(e.getValue()).add(e.getKey());
        int[] res = new int[k];
        int idx = 0;
        for (int f = nums.length; f > 0 && idx < k; f--) {   // most frequent first
            for (int v : buckets.get(f)) {
                if (idx < k) res[idx++] = v;
            }
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Sorting all map entries by frequency — O(n log n), fine but not the best.

---

⬅️ [Previous: Kth Largest Element in an Array](./003-kth-largest-element-in-an-array.md) · [📋 Heaps & Priority Queue list](./README.md) · [Next: K Closest Points to Origin](./005-k-closest-points-to-origin.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
