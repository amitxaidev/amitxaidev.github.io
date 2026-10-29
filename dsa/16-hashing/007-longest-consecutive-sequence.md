# 7. Longest Consecutive Sequence

**LeetCode 128** · 🟡 Medium · Pattern: **HashSet, start only at run starts**
🔗 Solve it here: [https://leetcode.com/problems/longest-consecutive-sequence/](https://leetcode.com/problems/longest-consecutive-sequence/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/007-longest-consecutive-sequence.html](https://amitxaidev.github.io/dsa/16-hashing/007-longest-consecutive-sequence.html)

## The problem, in short

Return the length of the longest run of consecutive integers (like 4, 5, 6, 7) found in an unsorted array, in O(n).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Put everything in a HashSet.

</details>

<details>
<summary>💡 Hint 2</summary>

Only start counting from x when x − 1 is NOT in the set — x is the start of a run.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each run start, count upward while x + 1, x + 2, … exist. Each number is visited by at most one count, so the total work is O(n).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int best = 0;
        for (int x : set) {
            if (set.contains(x - 1)) continue;   // not a run start
            int len = 1;
            while (set.contains(x + len)) len++;
            best = Math.max(best, len);
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

⚠️ Counting upward from every number, which makes it O(n²) on one long run.

---

⬅️ [Previous: Happy Number](./006-happy-number.md) · [📋 Hashing list](./README.md) · [Next: 4Sum II](./008-4sum-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
