# 2. Contains Duplicate

**LeetCode 217** · 🟢 Easy · Pattern: **HashSet**

## The problem, in short

Return true if any value appears at least twice in the array.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/contains-duplicate/](https://leetcode.com/problems/contains-duplicate/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/002-contains-duplicate.html](https://amitxaidev.github.io/dsa/16-hashing/002-contains-duplicate.html)

## Understanding

**Really asking:** does any value repeat?

**Why this works:** add to a set; a failed add means a repeat.

**Example:** [1, 2, 3, 1]
```text
add 1, 2, 3 ✓, add 1 ✗ → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

A HashSet remembers what you've seen in O(1) per lookup.

</details>

<details>
<summary>💡 Hint 2</summary>

Set.add returns false if the value was already present.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Add each value to a HashSet; the first failed add means a duplicate.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) return true;   // already there
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Using a List and contains() — that's O(n) per check, O(n²) overall.

---

⬅️ [Previous: Two Sum](./001-two-sum.md) · [📋 Hashing list](./README.md) · [Next: Intersection of Two Arrays](./003-intersection-of-two-arrays.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
