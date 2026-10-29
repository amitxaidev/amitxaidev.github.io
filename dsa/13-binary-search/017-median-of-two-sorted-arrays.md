# 17. Median of Two Sorted Arrays

**LeetCode 4** · 🔴 Hard · Pattern: **Binary search on the partition**

## The problem, in short

Return the median of two sorted arrays in O(log(m + n)).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/median-of-two-sorted-arrays/](https://leetcode.com/problems/median-of-two-sorted-arrays/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/017-median-of-two-sorted-arrays.html](https://amitxaidev.github.io/dsa/13-binary-search/017-median-of-two-sorted-arrays.html)

## Understanding

**Really asking:** the median of two sorted arrays combined, in O(log).

**Why this works:** cut both arrays so the left halves hold half of all numbers. The cut is right when every left number ≤ every right number. Binary search where to cut the smaller array.

**Example:** [1, 3] and [2]
```text
cut A after 1 element, B after 1 → left {1, 2}, right {3}
max(left) = 2 ≤ min(right) = 3 ✓
odd total → median 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Cut both arrays so the left parts together hold half of all elements.

</details>

<details>
<summary>💡 Hint 2</summary>

The cut is correct when every left element is &lt;= every right element: A[i−1] &lt;= B[j] and B[j−1] &lt;= A[i].

</details>

<details>
<summary>💡 Hint 3</summary>

Binary search the cut position i in the smaller array; j follows from i.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Let A be the shorter array. Binary search i in [0, m]; j = (m + n + 1) / 2 − i. If A[i−1] > B[j], move i left; if B[j−1] > A[i], move right. With the right cut, the median comes from the max of the left sides and the min of the right sides. Use ±infinity for empty sides.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);   // search the shorter one
        int m = a.length, n = b.length, half = (m + n + 1) / 2;
        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1, j = half - i;
            int aLeft = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int aRight = i == m ? Integer.MAX_VALUE : a[i];
            int bLeft = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int bRight = j == n ? Integer.MAX_VALUE : b[j];
            if (aLeft > bRight) hi = i - 1;
            else if (bLeft > aRight) lo = i + 1;
            else {
                int leftMax = Math.max(aLeft, bLeft);
                if ((m + n) % 2 == 1) return leftMax;
                return (leftMax + (double) Math.min(aRight, bRight)) / 2;
            }
        }
        return 0;   // not reached for valid input
    }
}
```

</details>

## Complexity

- **Time:** O(log min(m, n)).
- **Space:** O(1).

## Common mistake

⚠️ Binary searching the longer array, which makes j go out of range.

---

⬅️ [Previous: Split Array Largest Sum](./016-split-array-largest-sum.md) · [📋 Binary Search list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
