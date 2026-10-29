# 9. Max Number of K-Sum Pairs

**LeetCode 1679** · 🟡 Medium · Pattern: **HashMap pairing**
🔗 Solve it here: [https://leetcode.com/problems/max-number-of-k-sum-pairs/](https://leetcode.com/problems/max-number-of-k-sum-pairs/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/009-max-number-of-k-sum-pairs.html](https://amitxaidev.github.io/dsa/16-hashing/009-max-number-of-k-sum-pairs.html)

## The problem, in short

In one operation you remove two numbers that sum to k. Return the most operations you can do.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

This is Two Sum, but each number can be used once.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep counts of unmatched numbers; when the complement is available, use it up.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each x, if count[k − x] > 0, decrement it and add one operation; otherwise increment count[x].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> waiting = new HashMap<>();
        int ops = 0;
        for (int x : nums) {
            int need = k - x;
            int c = waiting.getOrDefault(need, 0);
            if (c > 0) {
                waiting.put(need, c - 1);   // pair x with a waiting partner
                ops++;
            } else {
                waiting.merge(x, 1, Integer::sum);
            }
        }
        return ops;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Counting x with itself when x = k − x and only one copy is available — checking before storing x avoids it.

---

⬅️ [Previous: 4Sum II](./008-4sum-ii.md) · [📋 Hashing list](./README.md) · [Next: Brick Wall](./010-brick-wall.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
