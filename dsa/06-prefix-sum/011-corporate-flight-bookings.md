# 11. Corporate Flight Bookings

**LeetCode 1109** · 🟡 Medium · Pattern: **Difference array**
🔗 Solve it here: [https://leetcode.com/problems/corporate-flight-bookings/](https://leetcode.com/problems/corporate-flight-bookings/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/011-corporate-flight-bookings.html](https://amitxaidev.github.io/dsa/06-prefix-sum/011-corporate-flight-bookings.html)

## The problem, in short

There are n flights. Each booking [first, last, seats] reserves seats on every flight from first to last. Return the total seats for each flight.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Adding to every flight in a range for every booking is too slow.

</details>

<details>
<summary>💡 Hint 2</summary>

Mark only the edges: +seats at first, -seats right after last.

</details>

<details>
<summary>💡 Hint 3</summary>

A prefix sum over those marks gives the real totals.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Difference array: diff[first-1] += seats and diff[last] -= seats (if in range). Then take the running sum. Each booking costs O(1).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] b : bookings) {
            ans[b[0] - 1] += b[2];        // range starts
            if (b[1] < n) ans[b[1]] -= b[2];   // range ends after flight b[1]
        }
        for (int i = 1; i < n; i++) ans[i] += ans[i - 1];
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n + b), b = number of bookings.
- **Space:** O(n).

## Common mistake

⚠️ Mixing 1-based flight numbers with 0-based indexes — subtract one from first, and last becomes the "after" index.

---

⬅️ [Previous: Continuous Subarray Sum](./010-continuous-subarray-sum.md) · [📋 Prefix Sum list](./README.md) · [Next: Number of Submatrices That Sum to Target](./012-number-of-submatrices-that-sum-to-target.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
