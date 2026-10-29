# 9. Subarray Sums Divisible by K

**LeetCode 974** · 🟡 Medium · Pattern: **Prefix remainders**
🔗 Solve it here: [https://leetcode.com/problems/subarray-sums-divisible-by-k/](https://leetcode.com/problems/subarray-sums-divisible-by-k/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/009-subarray-sums-divisible-by-k.html](https://amitxaidev.github.io/dsa/06-prefix-sum/009-subarray-sums-divisible-by-k.html)

## The problem, in short

Count the non-empty subarrays whose sum is divisible by k.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A subarray sum is divisible by k when two prefix sums have the same remainder mod k.

</details>

<details>
<summary>💡 Hint 2</summary>

Java's % can be negative — normalise with ((sum % k) + k) % k.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count how many prefixes have each remainder (start with remainder 0 seen once). For each new prefix, add the count of previous prefixes with the same remainder.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int sum = 0, ans = 0;
        for (int x : nums) {
            sum += x;
            int r = ((sum % k) + k) % k;   // always 0..k-1
            ans += count[r];
            count[r]++;
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(k).

## Common mistake

⚠️ Not fixing negative remainders, so -1 and k-1 are counted as different buckets.

---

⬅️ [Previous: Contiguous Array](./008-contiguous-array.md) · [📋 Prefix Sum list](./README.md) · [Next: Continuous Subarray Sum](./010-continuous-subarray-sum.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
