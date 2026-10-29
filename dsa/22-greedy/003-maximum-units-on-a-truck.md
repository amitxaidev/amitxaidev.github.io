# 3. Maximum Units on a Truck

**LeetCode 1710** · 🟢 Easy · Pattern: **Fractional-knapsack style**
🔗 Solve it here: [https://leetcode.com/problems/maximum-units-on-a-truck/](https://leetcode.com/problems/maximum-units-on-a-truck/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/003-maximum-units-on-a-truck.html](https://amitxaidev.github.io/dsa/22-greedy/003-maximum-units-on-a-truck.html)

## The problem, in short

Box types come as [count, unitsPerBox]. A truck holds at most truckSize boxes. Maximise the total units loaded.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Every box takes one slot, so take the boxes with the most units first.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort by units per box, descending.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

This is the "fractional knapsack" idea with equal weights: sort by value per box and fill greedily, taking min(count, remaining slots) of each type.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);   // most units per box first
        int units = 0;
        for (int[] t : boxTypes) {
            int take = Math.min(t[0], truckSize);
            units += take * t[1];
            truckSize -= take;
            if (truckSize == 0) break;
        }
        return units;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(log n) for sorting.

## Common mistake

⚠️ Sorting by box count instead of units per box.

---

⬅️ [Previous: Lemonade Change](./002-lemonade-change.md) · [📋 Greedy list](./README.md) · [Next: Best Time to Buy and Sell Stock II](./004-best-time-to-buy-and-sell-stock-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
