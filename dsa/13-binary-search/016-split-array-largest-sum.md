# 16. Split Array Largest Sum

**LeetCode 410** · 🔴 Hard · Pattern: **Binary search on the answer (book allocation)**

## The problem, in short

Split the array into k non-empty contiguous parts so that the largest part's sum is as small as possible. Return that sum.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/split-array-largest-sum/](https://leetcode.com/problems/split-array-largest-sum/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/016-split-array-largest-sum.html](https://amitxaidev.github.io/dsa/13-binary-search/016-split-array-largest-sum.html)

## Understanding

**Really asking:** cut the array into k parts so the biggest part sum is as small as possible ("book allocation").

**Why this works:** guess a limit; greedily count how many parts you need. Fewer parts than k is fine. Binary search the smallest workable limit.

**Example:** [7, 2, 5, 10, 8], k = 2
```text
limit 18: [7,2,5] [10,8] → 2 parts ✓
limit 17: [7,2,5] [10] [8] → 3 parts ✗ → answer 18
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Guess a limit L for the largest part. Can you split into at most k parts with every part ≤ L?

</details>

<details>
<summary>💡 Hint 2</summary>

Greedy check: keep adding to the current part until it would exceed L, then start a new part.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

This is "book allocation". Binary search L in [max element, total]. If greedy needs at most k parts, L is feasible — search lower.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int splitArray(int[] nums, int k) {
        long lo = 0, hi = 0;
        for (int x : nums) {
            lo = Math.max(lo, x);
            hi += x;
        }
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (parts(nums, mid) <= k) hi = mid;
            else lo = mid + 1;
        }
        return (int) lo;
    }

    private int parts(int[] nums, long limit) {
        int parts = 1;
        long sum = 0;
        for (int x : nums) {
            if (sum + x > limit) {   // start a new part
                parts++;
                sum = 0;
            }
            sum += x;
        }
        return parts;
    }
}
```

</details>

## Complexity

- **Time:** O(n log(sum)).
- **Space:** O(1).

## Common mistake

⚠️ Thinking "at most k parts" is a problem — if fewer parts fit, you can always split further without increasing the max.

---

⬅️ [Previous: Magnetic Force Between Two Balls](./015-magnetic-force-between-two-balls.md) · [📋 Binary Search list](./README.md) · [Next: Median of Two Sorted Arrays](./017-median-of-two-sorted-arrays.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
