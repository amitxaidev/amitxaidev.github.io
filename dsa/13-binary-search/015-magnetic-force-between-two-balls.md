# 15. Magnetic Force Between Two Balls

**LeetCode 1552** · 🟡 Medium · Pattern: **Binary search on the answer (aggressive cows)**

## The problem, in short

Place m balls into baskets at given positions so that the minimum distance between any two balls is as large as possible. Return that distance.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/magnetic-force-between-two-balls/](https://leetcode.com/problems/magnetic-force-between-two-balls/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/015-magnetic-force-between-two-balls.html](https://amitxaidev.github.io/dsa/13-binary-search/015-magnetic-force-between-two-balls.html)

## Understanding

**Really asking:** place m balls to make the closest pair as far apart as possible ("aggressive cows").

**Why this works:** if a minimum gap d is possible, every smaller gap is too. Binary search d and place balls greedily from the left.

**Example:** positions [1, 2, 3, 4, 7], m = 3
```text
d=3: place at 1, 4, 7 ✓
d=4: place at 1, 7 only ✗ → answer 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort the positions.

</details>

<details>
<summary>💡 Hint 2</summary>

For a distance d, place balls greedily: first basket, then the next basket at least d further, and so on.

</details>

<details>
<summary>💡 Hint 3</summary>

If d works, every smaller d works — find the largest feasible d.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

This is the classic "aggressive cows". Binary search d in [1, max − min]. Feasible if the greedy placement fits at least m balls.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = position[position.length - 1] - position[0];
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;   // upper mid: we're finding the last true
            if (canPlace(position, m, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private boolean canPlace(int[] pos, int m, int d) {
        int count = 1, last = pos[0];
        for (int i = 1; i < pos.length && count < m; i++) {
            if (pos[i] - last >= d) {
                count++;
                last = pos[i];
            }
        }
        return count >= m;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n + n log R).
- **Space:** O(1) besides sorting.

## Common mistake

⚠️ Searching for the first feasible value (lower bound) when you need the last feasible one — use mid = (lo + hi + 1) / 2 with lo = mid.

---

⬅️ [Previous: Find the Smallest Divisor Given a Threshold](./014-find-the-smallest-divisor-given-a-threshold.md) · [📋 Binary Search list](./README.md) · [Next: Split Array Largest Sum](./016-split-array-largest-sum.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
