# 9. Fruit Into Baskets

**LeetCode 904** · 🟡 Medium · Pattern: **Variable window, at most 2 kinds**
🔗 Solve it here: [https://leetcode.com/problems/fruit-into-baskets/](https://leetcode.com/problems/fruit-into-baskets/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/009-fruit-into-baskets.html](https://amitxaidev.github.io/dsa/08-sliding-window/009-fruit-into-baskets.html)

## The problem, in short

Trees in a row each give one fruit type. With two baskets (one type each), pick from a contiguous stretch of trees. Return the most fruit you can collect.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Rephrase: the longest subarray with at most 2 distinct values.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a count per type in the window; shrink when there are 3 types.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Expand right and count types in a map. While the map has more than 2 keys, decrement the left type (removing it at 0) and move left. Track the longest window.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, best = 0;
        for (int r = 0; r < fruits.length; r++) {
            count.merge(fruits[r], 1, Integer::sum);
            while (count.size() > 2) {
                int f = fruits[left++];
                if (count.merge(f, -1, Integer::sum) == 0) count.remove(f);   // drop empty baskets
            }
            best = Math.max(best, r - left + 1);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1) — at most 3 keys.

## Common mistake

⚠️ Leaving zero-count keys in the map, so map.size() stays too large.

---

⬅️ [Previous: Max Consecutive Ones III](./008-max-consecutive-ones-iii.md) · [📋 Sliding Window list](./README.md) · [Next: Maximum Number of Vowels in a Substring of Given Length](./010-maximum-number-of-vowels-in-a-substring-of-given-length.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
