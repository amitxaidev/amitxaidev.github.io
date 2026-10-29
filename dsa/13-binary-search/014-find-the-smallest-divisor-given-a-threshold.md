# 14. Find the Smallest Divisor Given a Threshold

**LeetCode 1283** · 🟡 Medium · Pattern: **Binary search on the answer**
🔗 Solve it here: [https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/014-find-the-smallest-divisor-given-a-threshold.html](https://amitxaidev.github.io/dsa/13-binary-search/014-find-the-smallest-divisor-given-a-threshold.html)

## The problem, in short

Pick a positive divisor, divide every number by it rounding up, and sum the results. Return the smallest divisor whose sum is at most threshold.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A bigger divisor never makes the sum bigger.

</details>

<details>
<summary>💡 Hint 2</summary>

Search the divisor between 1 and the maximum element.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search the first divisor d with sum(ceil(x / d)) &lt;= threshold.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 0;
        for (int x : nums) hi = Math.max(hi, x);
        while (lo < hi) {
            int d = (lo + hi) >>> 1;
            long sum = 0;
            for (int x : nums) sum += (x + d - 1) / d;
            if (sum <= threshold) hi = d;
            else lo = d + 1;
        }
        return lo;
    }
}
```

</details>

## Complexity

- **Time:** O(n log M).
- **Space:** O(1).

## Common mistake

⚠️ Using normal integer division instead of rounding up: use (x + d − 1) / d.

---

⬅️ [Previous: Minimum Number of Days to Make m Bouquets](./013-minimum-number-of-days-to-make-m-bouquets.md) · [📋 Binary Search list](./README.md) · [Next: Magnetic Force Between Two Balls](./015-magnetic-force-between-two-balls.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
