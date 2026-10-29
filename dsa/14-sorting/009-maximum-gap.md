# 9. Maximum Gap

**LeetCode 164** · 🟡 Medium · Pattern: **Bucket sort (pigeonhole)**

## The problem, in short

Return the largest difference between consecutive elements after sorting, in linear time and space. Return 0 for fewer than two elements.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/maximum-gap/](https://leetcode.com/problems/maximum-gap/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/009-maximum-gap.html](https://amitxaidev.github.io/dsa/14-sorting/009-maximum-gap.html)

## Understanding

**Really asking:** the biggest gap between neighbours after sorting, in O(n).

**Why this works:** with n numbers spread over [min, max], the biggest gap is at least (max-min)/(n-1). Buckets that small can't contain the biggest gap, so only compare between buckets.

**Example:** [3, 6, 9, 1] → min 1, max 9, bucket size 3
```text
buckets: [1,3], [6], [9]
gaps: 6-3 = 3, 9-6 = 3 → answer 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

With n numbers between min and max, the maximum gap is at least (max − min) / (n − 1).

</details>

<details>
<summary>💡 Hint 2</summary>

Use buckets of about that size: the maximum gap can't be inside one bucket, only between buckets.

</details>

<details>
<summary>💡 Hint 3</summary>

Each bucket only needs its min and max.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Make n − 1 buckets of size ceil((max − min) / (n − 1)). Store each bucket's min and max. Walk the non-empty buckets; the answer is the largest (bucket min − previous bucket max).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) { min = Math.min(min, x); max = Math.max(max, x); }
        if (min == max) return 0;
        int size = Math.max(1, (max - min + n - 2) / (n - 1));   // ceil, at least 1
        int count = (max - min) / size + 1;
        int[] bMin = new int[count], bMax = new int[count];
        Arrays.fill(bMin, Integer.MAX_VALUE);
        Arrays.fill(bMax, Integer.MIN_VALUE);
        for (int x : nums) {
            int b = (x - min) / size;
            bMin[b] = Math.min(bMin[b], x);
            bMax[b] = Math.max(bMax[b], x);
        }
        int best = 0, prevMax = min;
        for (int b = 0; b < count; b++) {
            if (bMin[b] == Integer.MAX_VALUE) continue;   // empty bucket
            best = Math.max(best, bMin[b] - prevMax);      // gap between buckets
            prevMax = bMax[b];
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ A bucket size of 0 when all values are equal — use at least 1.

---

⬅️ [Previous: Custom Sort String](./008-custom-sort-string.md) · [📋 Sorting list](./README.md) · [Next: Count of Smaller Numbers After Self](./010-count-of-smaller-numbers-after-self.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
