# 7. Subarray Sum Equals K

**LeetCode 560** · 🟡 Medium · Pattern: **Prefix sum + HashMap**

## The problem, in short

Count the contiguous subarrays whose elements add up to exactly k. Values can be negative.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/subarray-sum-equals-k/](https://leetcode.com/problems/subarray-sum-equals-k/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/007-subarray-sum-equals-k.html](https://amitxaidev.github.io/dsa/06-prefix-sum/007-subarray-sum-equals-k.html)

## Understanding

**Really asking:** count contiguous pieces that add to exactly k (negatives allowed).

**Why this works:** a piece from i+1 to j sums to k when prefix[j] - prefix[i] = k. So at each j, count earlier prefixes equal to prefix[j] - k, using a HashMap.

**Example:** nums = [1, 1, 1], k = 2
```text
map {0:1}
sum 1: need -1 → 0;  map {0:1, 1:1}
sum 2: need 0  → +1; map {…, 2:1}
sum 3: need 1  → +1
answer 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

sum(i..j) = prefix[j] - prefix[i-1]. You want that to equal k.

</details>

<details>
<summary>💡 Hint 2</summary>

So at each j, count earlier prefixes equal to prefix[j] - k.

</details>

<details>
<summary>💡 Hint 3</summary>

Store counts of prefix sums in a HashMap, starting with {0: 1}.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan once with a running sum. Before storing the current sum, add map[sum - k] to the answer. The initial {0: 1} counts subarrays that start at index 0. Sliding window doesn't work here because negatives break the "shrink when too big" rule.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);                     // empty prefix
        int sum = 0, ans = 0;
        for (int x : nums) {
            sum += x;
            ans += count.getOrDefault(sum - k, 0);
            count.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Forgetting the {0: 1} entry, which misses every subarray starting at index 0.

---

⬅️ [Previous: Range Sum Query 2D - Immutable](./006-range-sum-query-2d-immutable.md) · [📋 Prefix Sum list](./README.md) · [Next: Contiguous Array](./008-contiguous-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
