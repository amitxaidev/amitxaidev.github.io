# 12. Boats to Save People

**LeetCode 881** · 🟡 Medium · Pattern: **Sort + opposite ends**
🔗 Solve it here: [https://leetcode.com/problems/boats-to-save-people/](https://leetcode.com/problems/boats-to-save-people/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/012-boats-to-save-people.html](https://amitxaidev.github.io/dsa/07-two-pointers/012-boats-to-save-people.html)

## The problem, in short

Each boat carries at most two people and has a weight limit. Return the minimum number of boats to carry everyone.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort by weight.

</details>

<details>
<summary>💡 Hint 2</summary>

The heaviest person goes in a boat now. Can the lightest person squeeze in too?

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sort, then pointers at the lightest and heaviest. The heaviest always boards; the lightest joins if the pair fits. Each step uses one boat.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, boats = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;   // lightest rides along
            r--;                                       // heaviest always leaves
            boats++;
        }
        return boats;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(log n) for sorting.

## Common mistake

⚠️ Pairing the heaviest with the heaviest who fits — the lightest is always the safest partner.

---

⬅️ [Previous: Remove Duplicates from Sorted Array II](./011-remove-duplicates-from-sorted-array-ii.md) · [📋 Two Pointers list](./README.md) · [Next: Trapping Rain Water](./013-trapping-rain-water.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
