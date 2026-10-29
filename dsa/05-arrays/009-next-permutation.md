# 9. Next Permutation

**LeetCode 31** · 🟡 Medium · Pattern: **Pivot + reverse**
🔗 Solve it here: [https://leetcode.com/problems/next-permutation/](https://leetcode.com/problems/next-permutation/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/009-next-permutation.html](https://amitxaidev.github.io/dsa/05-arrays/009-next-permutation.html)

## The problem, in short

Rearrange the array into the next larger ordering of its numbers in dictionary order. If it's already the largest, wrap around to the smallest. Do it in place.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

From the right, find the first index i with nums[i] &lt; nums[i + 1]. Everything right of i is decreasing.

</details>

<details>
<summary>💡 Hint 2</summary>

Swap nums[i] with the smallest value to its right that is still larger than it.

</details>

<details>
<summary>💡 Hint 3</summary>

Then reverse the part after i to make it as small as possible.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Find the pivot i scanning from the right. If none exists, reverse everything. Otherwise find j from the right with nums[j] > nums[i], swap, and reverse i+1..end (it's still decreasing, so reversing sorts it).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;   // find the pivot
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;             // just-larger element on the right
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);          // smallest possible suffix
    }

    private void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    private void reverse(int[] a, int l, int r) { while (l < r) swap(a, l++, r--); }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Sorting the suffix instead of reversing — correct but O(n log n), and it misses the key observation.

---

⬅️ [Previous: Rotate Array](./008-rotate-array.md) · [📋 Arrays list](./README.md) · [Next: Rearrange Array Elements by Sign](./010-rearrange-array-elements-by-sign.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
