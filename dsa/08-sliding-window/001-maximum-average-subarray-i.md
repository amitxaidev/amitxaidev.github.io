# 1. Maximum Average Subarray I

**LeetCode 643** · 🟢 Easy · Pattern: **Fixed window**
🔗 Solve it here: [https://leetcode.com/problems/maximum-average-subarray-i/](https://leetcode.com/problems/maximum-average-subarray-i/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/001-maximum-average-subarray-i.html](https://amitxaidev.github.io/dsa/08-sliding-window/001-maximum-average-subarray-i.html)

## The problem, in short

Find the contiguous subarray of length k with the largest average and return that average.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The largest average comes from the largest sum, since k is fixed.

</details>

<details>
<summary>💡 Hint 2</summary>

When the window slides, add the new element and subtract the one that left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sum the first k elements. Then slide: sum += nums[i] - nums[i - k]. Track the best sum and divide by k at the end.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        int best = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];   // slide by one
            best = Math.max(best, sum);
        }
        return (double) best / k;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Re-summing all k elements for every window — O(n·k).

---

[📋 Sliding Window list](./README.md) · [Next: Contains Duplicate II](./002-contains-duplicate-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
