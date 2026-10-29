# 11. Koko Eating Bananas

**LeetCode 875** · 🟡 Medium · Pattern: **Binary search on the answer**

## The problem, in short

Koko eats from one pile per hour at speed k bananas/hour (a smaller pile still takes the full hour). Find the minimum k that lets her finish all piles within h hours.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/koko-eating-bananas/](https://leetcode.com/problems/koko-eating-bananas/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/011-koko-eating-bananas.html](https://amitxaidev.github.io/dsa/13-binary-search/011-koko-eating-bananas.html)

## Understanding

**Really asking:** the slowest eating speed that still finishes all piles in h hours.

**Why this works:** faster always works if slower works, so binary search the speed and count hours = sum of ceil(pile / speed).

**Example:** piles [3, 6, 7, 11], h = 8
```text
speed 4: 1+2+2+3 = 8 ✓
speed 3: 1+2+3+4 = 10 ✗
answer 4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

If speed k works, any faster speed works too. That's monotonic — binary search on k.

</details>

<details>
<summary>💡 Hint 2</summary>

Hours needed at speed k = sum of ceil(pile / k).

</details>

<details>
<summary>💡 Hint 3</summary>

k ranges from 1 to the largest pile.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search k in [1, max]. If hours(k) &lt;= h, try smaller (hi = k); otherwise lo = k + 1. ceil(p / k) = (p + k − 1) / k.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);
        while (lo < hi) {
            int k = (lo + hi) >>> 1;
            if (hours(piles, k) <= h) hi = k;   // fast enough, try slower
            else lo = k + 1;
        }
        return lo;
    }

    private long hours(int[] piles, int k) {
        long total = 0;
        for (int p : piles) total += (p + k - 1) / k;   // ceil(p / k)
        return total;
    }
}
```

</details>

## Complexity

- **Time:** O(n log M), M = largest pile.
- **Space:** O(1).

## Common mistake

⚠️ Summing hours in int — with many piles and k = 1 it can overflow. Use long.

---

⬅️ [Previous: Single Element in a Sorted Array](./010-single-element-in-a-sorted-array.md) · [📋 Binary Search list](./README.md) · [Next: Capacity To Ship Packages Within D Days](./012-capacity-to-ship-packages-within-d-days.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
