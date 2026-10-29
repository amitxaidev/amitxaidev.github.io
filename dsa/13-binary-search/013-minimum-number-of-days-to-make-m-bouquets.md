# 13. Minimum Number of Days to Make m Bouquets

**LeetCode 1482** · 🟡 Medium · Pattern: **Binary search on the answer**
🔗 Solve it here: [https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/013-minimum-number-of-days-to-make-m-bouquets.html](https://amitxaidev.github.io/dsa/13-binary-search/013-minimum-number-of-days-to-make-m-bouquets.html)

## The problem, in short

Flower i blooms on bloomDay[i]. A bouquet needs k adjacent bloomed flowers. Return the earliest day you can make m bouquets, or -1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If m·k > n, it's impossible.

</details>

<details>
<summary>💡 Hint 2</summary>

If you can make m bouquets by day d, you can on any later day too.

</details>

<details>
<summary>💡 Hint 3</summary>

For a day d, scan left to right counting runs of bloomed flowers.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search d between the smallest and largest bloom day. Feasibility: walk the array, extend the current run when bloomDay[i] &lt;= d, and cut a bouquet whenever the run reaches k.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int lo = Integer.MAX_VALUE, hi = 0;
        for (int d : bloomDay) {
            lo = Math.min(lo, d);
            hi = Math.max(hi, d);
        }
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (bouquets(bloomDay, mid, k) >= m) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int bouquets(int[] bloomDay, int day, int k) {
        int made = 0, run = 0;
        for (int d : bloomDay) {
            if (d <= day) {
                if (++run == k) { made++; run = 0; }   // cut a bouquet
            } else {
                run = 0;
            }
        }
        return made;
    }
}
```

</details>

## Complexity

- **Time:** O(n log D).
- **Space:** O(1).

## Common mistake

⚠️ Computing m * k in int — both can be 10^5 / 10^6 and overflow. Use long.

---

⬅️ [Previous: Capacity To Ship Packages Within D Days](./012-capacity-to-ship-packages-within-d-days.md) · [📋 Binary Search list](./README.md) · [Next: Find the Smallest Divisor Given a Threshold](./014-find-the-smallest-divisor-given-a-threshold.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
