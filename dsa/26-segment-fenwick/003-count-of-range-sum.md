# 3. Count of Range Sum

**LeetCode 327** · 🔴 Hard · Pattern: **Fenwick tree over compressed prefix sums**
🔗 Solve it here: [https://leetcode.com/problems/count-of-range-sum/](https://leetcode.com/problems/count-of-range-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/26-segment-fenwick/003-count-of-range-sum.html](https://amitxaidev.github.io/dsa/26-segment-fenwick/003-count-of-range-sum.html)

## The problem, in short

Count subarrays whose sum lies within [lower, upper].

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

With prefix sums P, a subarray (i, j] is valid when lower ≤ P[j] − P[i] ≤ upper.

</details>

<details>
<summary>💡 Hint 2</summary>

For each j, count earlier prefixes P[i] in [P[j] − upper, P[j] − lower].

</details>

<details>
<summary>💡 Hint 3</summary>

Coordinate-compress all prefix sums and count them with a Fenwick tree.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Compute long prefix sums, sort the distinct values, and for each P[j] in order: query how many earlier prefixes fall in the window (two binary searches + two BIT prefix queries), then add P[j] to the BIT.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private int[] tree;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        long[] sorted = Arrays.stream(pre).distinct().sorted().toArray();
        tree = new int[sorted.length + 1];
        int count = 0;
        for (long p : pre) {
            int hi = upperIndex(sorted, p - lower);        // values <= p - lower
            int lo = upperIndex(sorted, p - upper - 1);    // values <= p - upper - 1
            count += query(hi) - query(lo);
            add(Arrays.binarySearch(sorted, p) + 1);
        }
        return count;
    }

    // number of sorted values <= x
    private int upperIndex(long[] a, long x) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private void add(int i) {
        for (; i < tree.length; i += i & -i) tree[i]++;
    }

    private int query(int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) s += tree[i];
        return s;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Using int prefix sums — they overflow with values near 2^31.

---

⬅️ [Previous: My Calendar I](./002-my-calendar-i.md) · [📋 Segment Tree, Fenwick & Sparse Table list](./README.md) · [Next: Create Sorted Array through Instructions](./004-create-sorted-array-through-instructions.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
