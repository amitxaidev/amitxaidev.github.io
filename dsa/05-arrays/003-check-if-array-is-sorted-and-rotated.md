# 3. Check if Array Is Sorted and Rotated

**LeetCode 1752** · 🟢 Easy · Pattern: **Count drops**
🔗 Solve it here: [https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/003-check-if-array-is-sorted-and-rotated.html](https://amitxaidev.github.io/dsa/05-arrays/003-check-if-array-is-sorted-and-rotated.html)

## The problem, in short

Decide whether the array could be a non-decreasing array that was rotated some number of positions (duplicates allowed).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

In a sorted array there is no place where a value is larger than the next one.

</details>

<details>
<summary>💡 Hint 2</summary>

In a rotated sorted array there is at most one such "drop" — if you also compare the last element with the first.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count indexes i where nums[i] > nums[(i + 1) % n]. The array is a rotated sorted array exactly when that count is at most 1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, drops = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) drops++;   // includes last -> first
        }
        return drops <= 1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting the wrap-around comparison between the last and first element.

---

⬅️ [Previous: Max Consecutive Ones](./002-max-consecutive-ones.md) · [📋 Arrays list](./README.md) · [Next: Best Time to Buy and Sell Stock](./004-best-time-to-buy-and-sell-stock.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
