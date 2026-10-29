# 3. Intersection of Two Arrays

**LeetCode 349** · 🟢 Easy · Pattern: **HashSet**
🔗 Solve it here: [https://leetcode.com/problems/intersection-of-two-arrays/](https://leetcode.com/problems/intersection-of-two-arrays/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/003-intersection-of-two-arrays.html](https://amitxaidev.github.io/dsa/16-hashing/003-intersection-of-two-arrays.html)

## The problem, in short

Return the distinct values present in both arrays.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Put one array into a set.

</details>

<details>
<summary>💡 Hint 2</summary>

Walk the other array; when a value is in the set, record it and remove it so it's recorded once.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Set from nums1, then for each value of nums2 that is removed successfully from the set, add it to the result.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) set.add(x);
        List<Integer> res = new ArrayList<>();
        for (int x : nums2) {
            if (set.remove(x)) res.add(x);   // remove so it's added once
        }
        int[] out = new int[res.size()];
        for (int i = 0; i < out.length; i++) out[i] = res.get(i);
        return out;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(n).

## Common mistake

⚠️ Returning duplicates when a common value repeats in nums2.

---

⬅️ [Previous: Contains Duplicate](./002-contains-duplicate.md) · [📋 Hashing list](./README.md) · [Next: Word Pattern](./004-word-pattern.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
