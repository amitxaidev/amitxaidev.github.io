# 1. Two Sum

**LeetCode 1** · 🟢 Easy · Pattern: **HashMap complement lookup**
🔗 Solve it here: [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/001-two-sum.html](https://amitxaidev.github.io/dsa/16-hashing/001-two-sum.html)

## The problem, in short

Return the indexes of the two numbers that add up to target. Exactly one answer exists and the same element can't be used twice.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For each number x, you need target − x.

</details>

<details>
<summary>💡 Hint 2</summary>

Store numbers you've already seen in a HashMap: value → index.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass: before inserting x, look up target − x. If it's there, you've found the pair. Checking before inserting stops an element pairing with itself.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();   // value -> index
        for (int i = 0; i < nums.length; i++) {
            Integer j = seen.get(target - nums[i]);
            if (j != null) return new int[]{j, i};
            seen.put(nums[i], i);
        }
        return new int[0];
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Inserting x first and then looking up target − x, which can return the same index twice when x = target / 2.

---

[📋 Hashing list](./README.md) · [Next: Contains Duplicate](./002-contains-duplicate.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
