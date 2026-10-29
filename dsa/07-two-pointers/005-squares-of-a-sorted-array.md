# 5. Squares of a Sorted Array

**LeetCode 977** · 🟢 Easy · Pattern: **Opposite ends, fill from back**
🔗 Solve it here: [https://leetcode.com/problems/squares-of-a-sorted-array/](https://leetcode.com/problems/squares-of-a-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/005-squares-of-a-sorted-array.html](https://amitxaidev.github.io/dsa/07-two-pointers/005-squares-of-a-sorted-array.html)

## The problem, in short

Given a sorted array that may contain negatives, return the squares of all elements in sorted order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The largest square is at one of the two ends.

</details>

<details>
<summary>💡 Hint 2</summary>

Fill the result from the back with the larger of the two end squares.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Pointers at both ends. Compare absolute values, write the bigger square at the current back position of the result, and move that pointer inward.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[k] = nums[l] * nums[l];
                l++;
            } else {
                res[k] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the output.

## Common mistake

⚠️ Squaring then sorting — O(n log n) and misses the two-pointer idea.

---

⬅️ [Previous: Valid Palindrome](./004-valid-palindrome.md) · [📋 Two Pointers list](./README.md) · [Next: Is Subsequence](./006-is-subsequence.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
