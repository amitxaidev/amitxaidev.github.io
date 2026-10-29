# 14. Partition to K Equal Sum Subsets

**LeetCode 698** · 🟡 Medium · Pattern: **Backtracking with pruning**
🔗 Solve it here: [https://leetcode.com/problems/partition-to-k-equal-sum-subsets/](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/014-partition-to-k-equal-sum-subsets.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/014-partition-to-k-equal-sum-subsets.html)

## The problem, in short

Decide whether the array can be split into k groups that all have the same sum.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Each group must sum to total / k; if that's not an integer, return false.

</details>

<details>
<summary>💡 Hint 2</summary>

Place numbers (largest first) into buckets, backtracking on failure.

</details>

<details>
<summary>💡 Hint 3</summary>

If placing a number in an empty bucket fails, placing it in another empty bucket fails too — stop there.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sort descending. Recursively assign each number to a bucket whose sum stays within the target. Prune: skip buckets with the same current sum as one already tried, and stop after trying an empty bucket.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int x : nums) total += x;
        if (total % k != 0) return false;
        Arrays.sort(nums);
        int target = total / k;
        if (nums[nums.length - 1] > target) return false;
        return place(nums, nums.length - 1, new int[k], target);   // largest first
    }

    private boolean place(int[] nums, int i, int[] bucket, int target) {
        if (i < 0) return true;                 // every number placed
        for (int b = 0; b < bucket.length; b++) {
            if (bucket[b] + nums[i] > target) continue;
            if (b > 0 && bucket[b] == bucket[b - 1]) continue;   // same state as a bucket already tried
            bucket[b] += nums[i];
            if (place(nums, i - 1, bucket, target)) return true;
            bucket[b] -= nums[i];
            if (bucket[b] == 0) break;          // failed in an empty bucket: no other empty bucket helps
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(k^n) worst case, far less with pruning.
- **Space:** O(n).

## Common mistake

⚠️ Not sorting in descending order — big numbers placed last cause much more backtracking.

---

⬅️ [Previous: Word Search](./013-word-search.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Path with Maximum Gold](./015-path-with-maximum-gold.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
