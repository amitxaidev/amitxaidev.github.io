# 13. Hand of Straights

**LeetCode 846** · 🟡 Medium · Pattern: **Smallest card starts a group**

## The problem, in short

Decide whether cards can be split into groups of groupSize consecutive values.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/hand-of-straights/](https://leetcode.com/problems/hand-of-straights/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/013-hand-of-straights.html](https://amitxaidev.github.io/dsa/22-greedy/013-hand-of-straights.html)

## Understanding

**Really asking:** split cards into groups of consecutive values.

**Why this works:** the smallest remaining card must start a group; take the next values right after it.

**Example:** [1,2,3,6,2,3,4,7,8], size 3
```text
[1,2,3], [2,3,4], [6,7,8] ✓
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The smallest remaining card must start a group.

</details>

<details>
<summary>💡 Hint 2</summary>

Use a TreeMap of counts so you can always find the smallest.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

While cards remain, take the smallest value v with count c; values v..v+groupSize−1 must each have at least c cards — subtract c from each.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int x : hand) count.merge(x, 1, Integer::sum);
        while (!count.isEmpty()) {
            int start = count.firstKey(), c = count.get(start);   // c groups start here
            for (int v = start; v < start + groupSize; v++) {
                Integer have = count.get(v);
                if (have == null || have < c) return false;
                if (have == c) count.remove(v);
                else count.put(v, have - c);
            }
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Forgetting the quick check n % groupSize != 0.

---

⬅️ [Previous: Valid Parenthesis String](./012-valid-parenthesis-string.md) · [📋 Greedy list](./README.md) · [Next: Candy](./014-candy.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
