# 12. Capacity To Ship Packages Within D Days

**LeetCode 1011** · 🟡 Medium · Pattern: **Binary search on the answer**

## The problem, in short

Packages must be shipped in the given order, with one ship trip per day. Find the smallest ship capacity that ships everything within the given number of days.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/012-capacity-to-ship-packages-within-d-days.html](https://amitxaidev.github.io/dsa/13-binary-search/012-capacity-to-ship-packages-within-d-days.html)

## Understanding

**Really asking:** the smallest ship capacity that ships everything, in order, within the days.

**Why this works:** bigger capacity never needs more days. Binary search between the heaviest package and the total weight, counting days greedily.

**Example:** [1..10], days 5
```text
capacity 15: [1-5] [6-7] [8] [9] [10] → 5 days ✓
capacity 14 needs 6 days ✗ → answer 15
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The capacity must be at least the heaviest package and at most the total weight.

</details>

<details>
<summary>💡 Hint 2</summary>

For a fixed capacity, count days greedily: fill a day until the next package doesn't fit.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search capacity in [max, sum]. Feasible capacities form a suffix, so find the first feasible one.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }
        while (lo < hi) {
            int cap = (lo + hi) >>> 1;
            if (daysNeeded(weights, cap) <= days) hi = cap;
            else lo = cap + 1;
        }
        return lo;
    }

    private int daysNeeded(int[] weights, int cap) {
        int days = 1, load = 0;
        for (int w : weights) {
            if (load + w > cap) {   // start a new day
                days++;
                load = 0;
            }
            load += w;
        }
        return days;
    }
}
```

</details>

## Complexity

- **Time:** O(n log(sum)).
- **Space:** O(1).

## Common mistake

⚠️ Starting the search at 1 — capacities below the heaviest package can never work and break the greedy count.

---

⬅️ [Previous: Koko Eating Bananas](./011-koko-eating-bananas.md) · [📋 Binary Search list](./README.md) · [Next: Minimum Number of Days to Make m Bouquets](./013-minimum-number-of-days-to-make-m-bouquets.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
