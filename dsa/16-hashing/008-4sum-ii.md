# 8. 4Sum II

**LeetCode 454** · 🟡 Medium · Pattern: **Meet in the middle with HashMap**
🔗 Solve it here: [https://leetcode.com/problems/4sum-ii/](https://leetcode.com/problems/4sum-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/008-4sum-ii.html](https://amitxaidev.github.io/dsa/16-hashing/008-4sum-ii.html)

## The problem, in short

Given four arrays of equal length, count tuples (i, j, k, l) with a[i] + b[j] + c[k] + d[l] == 0.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Four loops are O(n⁴).

</details>

<details>
<summary>💡 Hint 2</summary>

Count every sum a[i] + b[j] in a map.

</details>

<details>
<summary>💡 Hint 3</summary>

For every c[k] + d[l], look up its negative.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Split into two halves: store counts of all pairwise sums from a and b, then for each pair from c and d add map[−(c + d)].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> ab = new HashMap<>();
        for (int x : a)
            for (int y : b) ab.merge(x + y, 1, Integer::sum);
        int count = 0;
        for (int x : c)
            for (int y : d) count += ab.getOrDefault(-(x + y), 0);
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(n²).

## Common mistake

⚠️ Using a set instead of a count map, which ignores pairs with equal sums.

---

⬅️ [Previous: Longest Consecutive Sequence](./007-longest-consecutive-sequence.md) · [📋 Hashing list](./README.md) · [Next: Max Number of K-Sum Pairs](./009-max-number-of-k-sum-pairs.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
