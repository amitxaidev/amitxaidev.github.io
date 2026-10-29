# 2. Sort Array by Increasing Frequency

**LeetCode 1636** · 🟢 Easy · Pattern: **Custom comparator**

## The problem, in short

Sort numbers by how often they appear (rarest first). When two values are equally frequent, put the larger value first.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sort-array-by-increasing-frequency/](https://leetcode.com/problems/sort-array-by-increasing-frequency/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/002-sort-array-by-increasing-frequency.html](https://amitxaidev.github.io/dsa/14-sorting/002-sort-array-by-increasing-frequency.html)

## Understanding

**Really asking:** sort by how often each value appears; ties go bigger value first.

**Why this works:** count with a map, then sort with a two-key comparator.

**Example:** [2, 3, 1, 3, 2]
```text
freq: 1→1, 2→2, 3→2
1 first, then 3, 3 before 2, 2 (tie → bigger first)
[1, 3, 3, 2, 2]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Count frequencies with a HashMap.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort an Integer[] with a comparator: frequency ascending, then value descending.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Box the ints, sort with Arrays.sort and a two-key comparator, then unbox.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) boxed[i] = nums[i];
        Arrays.sort(boxed, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return Integer.compare(fa, fb);   // rarer first
            return Integer.compare(b, a);                   // then larger value first
        });
        for (int i = 0; i < nums.length; i++) nums[i] = boxed[i];
        return nums;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Trying to pass a comparator to Arrays.sort(int[]) — comparators only work on object arrays.

---

⬅️ [Previous: Height Checker](./001-height-checker.md) · [📋 Sorting list](./README.md) · [Next: Relative Sort Array](./003-relative-sort-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
