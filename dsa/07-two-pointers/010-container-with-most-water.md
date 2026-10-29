# 10. Container With Most Water

**LeetCode 11** · 🟡 Medium · Pattern: **Opposite ends, move the shorter**
🔗 Solve it here: [https://leetcode.com/problems/container-with-most-water/](https://leetcode.com/problems/container-with-most-water/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/010-container-with-most-water.html](https://amitxaidev.github.io/dsa/07-two-pointers/010-container-with-most-water.html)

## The problem, in short

Vertical lines stand at each index with given heights. Pick two lines that, with the x-axis, hold the most water. Return that amount.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Water = width × the shorter of the two heights.

</details>

<details>
<summary>💡 Hint 2</summary>

Start with the widest container (both ends).

</details>

<details>
<summary>💡 Hint 3</summary>

Moving the taller line inward can never help. Move the shorter one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Two pointers at the ends. Record the area, then move whichever side is shorter, because the shorter line limits every container that uses it with a smaller width.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, best = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            best = Math.max(best, h * (r - l));
            if (height[l] < height[r]) l++;   // the shorter line is the bottleneck
            else r--;
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

⚠️ Moving the taller side, or moving both — you can skip the best pair.

---

⬅️ [Previous: 4Sum](./009-4sum.md) · [📋 Two Pointers list](./README.md) · [Next: Remove Duplicates from Sorted Array II](./011-remove-duplicates-from-sorted-array-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
