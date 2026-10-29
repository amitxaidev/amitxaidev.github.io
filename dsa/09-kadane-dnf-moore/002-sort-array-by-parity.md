# 2. Sort Array By Parity

**LeetCode 905** · 🟢 Easy · Pattern: **Two-way partition**

## The problem, in short

Rearrange the array so all even numbers come before all odd numbers. Any order inside each group is fine.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sort-array-by-parity/](https://leetcode.com/problems/sort-array-by-parity/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/002-sort-array-by-parity.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/002-sort-array-by-parity.html)

## Understanding

**Really asking:** evens first, odds after, any order inside.

**Why this works:** a boundary marks the end of the even zone; every even number found is swapped into it.

**Example:** [3, 1, 2, 4]
```text
3 odd, 1 odd
2 even → swap to index 0 → [2, 1, 3, 4]
4 even → swap to index 1 → [2, 4, 3, 1]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

This is the two-colour version of the Dutch National Flag.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a boundary: everything before it is even.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan with i; whenever nums[i] is even, swap it to the boundary and grow the boundary.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int t = nums[even];
                nums[even++] = nums[i];
                nums[i] = t;
            }
        }
        return nums;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Creating two lists and joining them — fine, but uses O(n) space for no reason.

---

⬅️ [Previous: Majority Element](./001-majority-element.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Maximum Subarray](./003-maximum-subarray.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
