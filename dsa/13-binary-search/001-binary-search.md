# 1. Binary Search

**LeetCode 704** · 🟢 Easy · Pattern: **Classic binary search**
🔗 Solve it here: [https://leetcode.com/problems/binary-search/](https://leetcode.com/problems/binary-search/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/001-binary-search.html](https://amitxaidev.github.io/dsa/13-binary-search/001-binary-search.html)

## The problem, in short

Find the index of target in a sorted array, or return -1, in O(log n).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compare with the middle element and throw away half.

</details>

<details>
<summary>💡 Hint 2</summary>

Use mid = lo + (hi - lo) / 2 to avoid overflow.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep lo and hi as the inclusive search range. If nums[mid] is the target, return it; if smaller, search right; otherwise search left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Writing lo = mid instead of lo = mid + 1, which can loop forever.

---

[📋 Binary Search list](./README.md) · [Next: Search Insert Position](./002-search-insert-position.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
