# 7. Two Sum II - Input Array Is Sorted

**LeetCode 167** · 🟡 Medium · Pattern: **Opposite ends**
🔗 Solve it here: [https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/007-two-sum-ii-input-array-is-sorted.html](https://amitxaidev.github.io/dsa/07-two-pointers/007-two-sum-ii-input-array-is-sorted.html)

## The problem, in short

In a sorted (1-indexed) array, find the two positions whose values add up to target. Use only constant extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Start with the smallest and largest values.

</details>

<details>
<summary>💡 Hint 2</summary>

Sum too small? Move the left pointer right. Too big? Move the right pointer left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Two pointers from both ends. Because the array is sorted, each move safely discards one value that can't be part of the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            if (sum < target) l++;
            else r--;
        }
        return new int[0];
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Returning 0-based indexes — this problem wants 1-based ones.

---

⬅️ [Previous: Is Subsequence](./006-is-subsequence.md) · [📋 Two Pointers list](./README.md) · [Next: 3Sum](./008-3sum.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
