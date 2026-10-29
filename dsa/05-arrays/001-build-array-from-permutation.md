# 1. Build Array from Permutation

**LeetCode 1920** · 🟢 Easy · Pattern: **Index mapping**

## The problem, in short

Given a permutation nums of 0..n-1, return ans where ans[i] = nums[nums[i]].

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/build-array-from-permutation/](https://leetcode.com/problems/build-array-from-permutation/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/001-build-array-from-permutation.html](https://amitxaidev.github.io/dsa/05-arrays/001-build-array-from-permutation.html)

## Understanding

**Really asking:** ans[i] = nums[nums[i]] — follow the pointer once.

**Why this works:** the simple version builds a new array. The in-place version stores two values in one slot (old + n × new), then divides by n.

**Example:** nums = [0, 2, 1, 5, 3, 4]
```text
i=0: nums[0]=0 → nums[0]=0
i=1: nums[1]=2 → nums[2]=1
i=3: nums[3]=5 → nums[5]=4
ans = [0, 1, 2, 4, 5, 3]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The direct version is a one-line loop with a new array.

</details>

<details>
<summary>💡 Hint 2</summary>

Follow-up: to do it in place, store two values in one slot: old + n × new.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

The simple answer builds a new array. The in-place version writes nums[i] += n * (nums[nums[i]] % n) — the % n recovers the old value even after a slot was updated — then divides every slot by n.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += n * (nums[nums[i]] % n);   // pack new value on top of the old one
        }
        for (int i = 0; i < n; i++) nums[i] /= n;  // keep only the new value
        return nums;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1) extra for the in-place version.

## Common mistake

⚠️ Doing the in-place update without % n, which reads already-modified values.

---

[📋 Arrays list](./README.md) · [Next: Max Consecutive Ones](./002-max-consecutive-ones.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
