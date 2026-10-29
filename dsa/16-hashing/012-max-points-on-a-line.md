# 12. Max Points on a Line

**LeetCode 149** · 🔴 Hard · Pattern: **HashMap of reduced slopes**
🔗 Solve it here: [https://leetcode.com/problems/max-points-on-a-line/](https://leetcode.com/problems/max-points-on-a-line/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/012-max-points-on-a-line.html](https://amitxaidev.github.io/dsa/16-hashing/012-max-points-on-a-line.html)

## The problem, in short

Given points on a plane, return the largest number of them that lie on one straight line.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Fix one point as an anchor; points on the same line through it share the same slope.

</details>

<details>
<summary>💡 Hint 2</summary>

Avoid floating-point slopes: store (dy, dx) reduced by their GCD with a fixed sign.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each anchor, count other points by normalised slope in a map. The best line through this anchor has (max count + 1) points. Points are distinct, so no duplicate handling is needed.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length, best = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) { dx = -dx; dy = -dy; }   // one sign per direction
                int c = slopes.merge(dy + "/" + dx, 1, Integer::sum);
                best = Math.max(best, c + 1);
            }
        }
        return best;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

</details>

## Complexity

- **Time:** O(n² log V) for the GCDs.
- **Space:** O(n).

## Common mistake

⚠️ Using double slopes — precision errors, and −0.0 vs 0.0 are different keys.

---

⬅️ [Previous: Equal Row and Column Pairs](./011-equal-row-and-column-pairs.md) · [📋 Hashing list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
