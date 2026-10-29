# 12. Find the Duplicate Number

**LeetCode 287** · 🟡 Medium · Pattern: **Floyd's cycle on indexes**

## The problem, in short

An array of n + 1 numbers has values in 1..n, so one value repeats (possibly many times). Find it without modifying the array and with O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/find-the-duplicate-number/](https://leetcode.com/problems/find-the-duplicate-number/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/012-find-the-duplicate-number.html](https://amitxaidev.github.io/dsa/05-arrays/012-find-the-duplicate-number.html)

## Understanding

**Really asking:** n+1 numbers in 1..n, so one repeats. Find it without changing the array or using extra memory.

**Why this works:** treat index → nums[index] as "next". Two indexes pointing to the same place form a loop, and the loop's entrance is the duplicate. Floyd's slow/fast pointers find it.

**Example:** [1, 3, 4, 2, 2]
```text
path: 0 → 1 → 3 → 2 → 4 → 2 → 4 …
loop is 2 → 4 → 2, entered at 2
answer 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Treat the array as a linked list: from index i go to index nums[i].

</details>

<details>
<summary>💡 Hint 2</summary>

A repeated value means two indexes point to the same next index — that's a cycle.

</details>

<details>
<summary>💡 Hint 3</summary>

The cycle's entrance is the duplicate. Use slow and fast pointers.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Floyd's algorithm: move slow one step and fast two steps until they meet. Reset one pointer to the start and move both one step at a time; where they meet again is the cycle entrance, which is the duplicate value.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);           // phase 1: meet inside the cycle
        slow = nums[0];
        while (slow != fast) {            // phase 2: find the entrance
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Sorting or marking with negatives — both modify the array, which the problem forbids.

---

⬅️ [Previous: Find All Duplicates in an Array](./011-find-all-duplicates-in-an-array.md) · [📋 Arrays list](./README.md) · [Next: H-Index](./013-h-index.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
