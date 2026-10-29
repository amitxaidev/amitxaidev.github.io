# 8. Contiguous Array

**LeetCode 525** · 🟡 Medium · Pattern: **Prefix sum + first index**
🔗 Solve it here: [https://leetcode.com/problems/contiguous-array/](https://leetcode.com/problems/contiguous-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/008-contiguous-array.html](https://amitxaidev.github.io/dsa/06-prefix-sum/008-contiguous-array.html)

## The problem, in short

In a binary array, find the length of the longest contiguous subarray with equally many 0s and 1s.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Treat 0 as -1. Then you want the longest subarray summing to 0.

</details>

<details>
<summary>💡 Hint 2</summary>

Two equal prefix sums mean the part between them sums to 0.

</details>

<details>
<summary>💡 Hint 3</summary>

Store the first index where each prefix sum appears.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Running sum with 0 → -1. A map stores the earliest index of each sum (sum 0 at index -1). When a sum repeats, the subarray from the stored index + 1 to now is balanced; keep the longest.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);
        int sum = 0, best = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (first.containsKey(sum)) best = Math.max(best, i - first.get(sum));
            else first.put(sum, i);          // keep only the earliest index
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

⚠️ Overwriting the stored index with later occurrences — you need the earliest to get the longest length.

---

⬅️ [Previous: Subarray Sum Equals K](./007-subarray-sum-equals-k.md) · [📋 Prefix Sum list](./README.md) · [Next: Subarray Sums Divisible by K](./009-subarray-sums-divisible-by-k.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
