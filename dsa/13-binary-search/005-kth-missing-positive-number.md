# 5. Kth Missing Positive Number

**LeetCode 1539** · 🟢 Easy · Pattern: **Binary search on a derived value**

## The problem, in short

Given a strictly increasing array of positive integers, return the k-th positive integer that is missing from it.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/kth-missing-positive-number/](https://leetcode.com/problems/kth-missing-positive-number/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/005-kth-missing-positive-number.html](https://amitxaidev.github.io/dsa/13-binary-search/005-kth-missing-positive-number.html)

## Understanding

**Really asking:** the k-th positive number that's not in the array.

**Why this works:** before index i, arr[i] - (i+1) numbers are missing, and that count only grows. Binary search the first index where it reaches k.

**Example:** [2, 3, 4, 7, 11], k = 5
```text
missing counts: 1, 1, 1, 3, 6
first index with count ≥ 5 is 4
answer 4 + 5 = 9
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Before index i, the count of missing numbers is arr[i] − (i + 1).

</details>

<details>
<summary>💡 Hint 2</summary>

That count never decreases. Find the first index where it reaches k.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search for the first i with arr[i] − i − 1 >= k. The answer is that index lo plus k (it falls just before arr[lo]).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] - mid - 1 < k) lo = mid + 1;   // not enough missing yet
            else hi = mid;
        }
        return lo + k;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Counting up one by one — O(n + k), fine for small inputs but misses the point.

---

⬅️ [Previous: First Bad Version](./004-first-bad-version.md) · [📋 Binary Search list](./README.md) · [Next: Find First and Last Position of Element in Sorted Array](./006-find-first-and-last-position-of-element-in-sorted-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
