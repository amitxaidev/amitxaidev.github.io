# 11. Reverse Pairs

**LeetCode 493** · 🔴 Hard · Pattern: **Merge sort counting**
🔗 Solve it here: [https://leetcode.com/problems/reverse-pairs/](https://leetcode.com/problems/reverse-pairs/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/011-reverse-pairs.html](https://amitxaidev.github.io/dsa/14-sorting/011-reverse-pairs.html)

## The problem, in short

Count pairs (i, j) with i &lt; j and nums[i] > 2 × nums[j].

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Inside merge sort, both halves are sorted before the merge.

</details>

<details>
<summary>💡 Hint 2</summary>

For each i in the left half, move a pointer j through the right half while nums[i] > 2·nums[j]. j never moves back.

</details>

<details>
<summary>💡 Hint 3</summary>

Use long for 2 × nums[j].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

In each merge step, first count pairs with a two-pointer sweep over the two sorted halves, then merge normally.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private int sort(int[] a, int[] tmp, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = (lo + hi) >>> 1;
        int count = sort(a, tmp, lo, mid) + sort(a, tmp, mid + 1, hi);
        for (int i = lo, j = mid + 1; i <= mid; i++) {
            while (j <= hi && a[i] > 2L * a[j]) j++;   // j only moves forward
            count += j - (mid + 1);
        }
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= hi) tmp[k++] = a[j++];
        System.arraycopy(tmp, lo, a, lo, hi - lo + 1);
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Computing 2 * nums[j] in int — values up to 2^31 overflow.

---

⬅️ [Previous: Count of Smaller Numbers After Self](./010-count-of-smaller-numbers-after-self.md) · [📋 Sorting list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
