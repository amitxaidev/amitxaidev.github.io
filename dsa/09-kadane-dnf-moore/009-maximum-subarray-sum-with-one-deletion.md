# 9. Maximum Subarray Sum with One Deletion

**LeetCode 1186** · 🟡 Medium · Pattern: **Kadane with two states**
🔗 Solve it here: [https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/009-maximum-subarray-sum-with-one-deletion.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/009-maximum-subarray-sum-with-one-deletion.html)

## The problem, in short

Return the largest sum of a non-empty subarray when you are allowed to delete at most one element from it (it must stay non-empty).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track two running values: best sum ending here with no deletion, and with one deletion used.

</details>

<details>
<summary>💡 Hint 2</summary>

With a deletion at i: either delete nums[i] itself (take the no-deletion sum before i), or the deletion happened earlier (extend that sum with nums[i]).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

keep = Kadane's value. del = max(previous keep (delete current), previous del + nums[i]). The answer is the max of both over all i. Initialise del very low so it never represents an empty subarray.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0], del = Integer.MIN_VALUE / 2, best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            del = Math.max(keep, del + x);       // delete x, or deleted earlier
            keep = Math.max(x, keep + x);        // plain Kadane
            best = Math.max(best, Math.max(keep, del));
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Letting the "deleted" state be an empty subarray, which wrongly returns 0 for all-negative input.

---

⬅️ [Previous: Majority Element II](./008-majority-element-ii.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
