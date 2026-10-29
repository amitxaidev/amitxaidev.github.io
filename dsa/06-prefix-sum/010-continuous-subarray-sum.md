# 10. Continuous Subarray Sum

**LeetCode 523** · 🟡 Medium · Pattern: **Prefix remainders + index**
🔗 Solve it here: [https://leetcode.com/problems/continuous-subarray-sum/](https://leetcode.com/problems/continuous-subarray-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/010-continuous-subarray-sum.html](https://amitxaidev.github.io/dsa/06-prefix-sum/010-continuous-subarray-sum.html)

## The problem, in short

Decide whether there is a subarray of length at least 2 whose sum is a multiple of k.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Equal remainders of two prefix sums mean the subarray between them sums to a multiple of k.

</details>

<details>
<summary>💡 Hint 2</summary>

Store the first index of each remainder and check that the gap is at least 2.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Map remainder → earliest index, starting with {0: -1}. For each i, if the remainder was seen at index j and i - j >= 2, return true. Only store a remainder the first time.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            Integer j = first.get(sum);
            if (j == null) first.put(sum, i);
            else if (i - j >= 2) return true;   // at least two elements
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(min(n, k)).

## Common mistake

⚠️ Storing the latest index; then a length-1 subarray can block a valid longer one.

---

⬅️ [Previous: Subarray Sums Divisible by K](./009-subarray-sums-divisible-by-k.md) · [📋 Prefix Sum list](./README.md) · [Next: Corporate Flight Bookings](./011-corporate-flight-bookings.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
