# 10. Count of Smaller Numbers After Self

**LeetCode 315** · 🔴 Hard · Pattern: **Merge sort with indexes**
🔗 Solve it here: [https://leetcode.com/problems/count-of-smaller-numbers-after-self/](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/010-count-of-smaller-numbers-after-self.html](https://amitxaidev.github.io/dsa/14-sorting/010-count-of-smaller-numbers-after-self.html)

## The problem, in short

For every element, count how many elements to its right are strictly smaller.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

During merge sort, when an element from the left half is placed, every element already taken from the right half is smaller and was to its right.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort indexes instead of values, so you know whose count to update.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Merge sort an index array by value. While merging, keep rightTaken = how many right-half elements were placed so far. When a left element is placed, add rightTaken to its count. Take from the left on ties so equal values aren't counted.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private int[] counts, idx, tmp, nums;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        counts = new int[n];
        idx = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        sort(0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int c : counts) res.add(c);
        return res;
    }

    private void sort(int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        sort(lo, mid);
        sort(mid + 1, hi);
        int i = lo, j = mid + 1, k = lo, rightTaken = 0;
        while (i <= mid && j <= hi) {
            if (nums[idx[j]] < nums[idx[i]]) {
                rightTaken++;                  // a smaller element from the right
                tmp[k++] = idx[j++];
            } else {
                counts[idx[i]] += rightTaken;
                tmp[k++] = idx[i++];
            }
        }
        while (i <= mid) {
            counts[idx[i]] += rightTaken;
            tmp[k++] = idx[i++];
        }
        while (j <= hi) tmp[k++] = idx[j++];
        System.arraycopy(tmp, lo, idx, lo, hi - lo + 1);
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Sorting the values directly — you lose track of which original position each count belongs to.

---

⬅️ [Previous: Maximum Gap](./009-maximum-gap.md) · [📋 Sorting list](./README.md) · [Next: Reverse Pairs](./011-reverse-pairs.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
