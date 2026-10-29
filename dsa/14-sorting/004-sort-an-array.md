# 4. Sort an Array

**LeetCode 912** · 🟡 Medium · Pattern: **Merge sort**
🔗 Solve it here: [https://leetcode.com/problems/sort-an-array/](https://leetcode.com/problems/sort-an-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/004-sort-an-array.html](https://amitxaidev.github.io/dsa/14-sorting/004-sort-an-array.html)

## The problem, in short

Sort an integer array in ascending order in O(n log n) without built-in sort functions.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Merge sort: split in half, sort each half, merge.

</details>

<details>
<summary>💡 Hint 2</summary>

Merging two sorted halves takes one pass with two pointers.

</details>

<details>
<summary>💡 Hint 3</summary>

Allocate one temp array up front instead of one per call.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Recursive merge sort with a shared buffer. It's stable and always O(n log n), unlike a naive quicksort that can hit O(n²) on sorted or repeated input (which LeetCode tests).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] a, int[] tmp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        mergeSort(a, tmp, lo, mid);
        mergeSort(a, tmp, mid + 1, hi);
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];   // <= keeps it stable
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= hi) tmp[k++] = a[j++];
        System.arraycopy(tmp, lo, a, lo, hi - lo + 1);
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Using quicksort with the first element as pivot — it times out on already-sorted input.

---

⬅️ [Previous: Relative Sort Array](./003-relative-sort-array.md) · [📋 Sorting list](./README.md) · [Next: Sort List](./005-sort-list.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
