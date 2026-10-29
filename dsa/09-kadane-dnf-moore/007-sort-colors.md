# 7. Sort Colors

**LeetCode 75** · 🟡 Medium · Pattern: **Dutch National Flag**
🔗 Solve it here: [https://leetcode.com/problems/sort-colors/](https://leetcode.com/problems/sort-colors/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/007-sort-colors.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/007-sort-colors.html)

## The problem, in short

The array contains only 0, 1 and 2. Sort it in place in one pass without using a library sort.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep three regions: 0s at the front, 2s at the back, 1s in the middle.

</details>

<details>
<summary>💡 Hint 2</summary>

Use pointers low, mid, high. Look at nums[mid].

</details>

<details>
<summary>💡 Hint 3</summary>

After swapping a 2 to the back, don't move mid — the swapped-in value hasn't been checked yet.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Dijkstra's three-way partition. 0 → swap with low, move low and mid. 1 → move mid. 2 → swap with high, move high only. Stop when mid passes high.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) swap(nums, low++, mid++);
            else if (nums[mid] == 1) mid++;
            else swap(nums, mid, high--);   // don't advance mid: new value unchecked
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
```

</details>

## Complexity

- **Time:** O(n), one pass.
- **Space:** O(1).

## Common mistake

⚠️ Advancing mid after swapping with high, which skips an unchecked element.

---

⬅️ [Previous: Maximum Absolute Sum of Any Subarray](./006-maximum-absolute-sum-of-any-subarray.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Majority Element II](./008-majority-element-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
