# 13. Trapping Rain Water

**LeetCode 42** · 🔴 Hard · Pattern: **Opposite ends with max heights**
🔗 Solve it here: [https://leetcode.com/problems/trapping-rain-water/](https://leetcode.com/problems/trapping-rain-water/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/013-trapping-rain-water.html](https://amitxaidev.github.io/dsa/07-two-pointers/013-trapping-rain-water.html)

## The problem, in short

Bars of given heights stand side by side. Return how much rain water is trapped between them.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Water above bar i = min(tallest bar on its left, tallest on its right) - height[i].

</details>

<details>
<summary>💡 Hint 2</summary>

Prefix and suffix max arrays give an O(n) space solution.

</details>

<details>
<summary>💡 Hint 3</summary>

With two pointers, the side with the smaller max is already decided.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep leftMax and rightMax. If leftMax &lt; rightMax, the water at l depends only on leftMax (the right side is guaranteed to be at least as tall), so add leftMax - height[l] and move l. Otherwise do the same on the right.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                water += leftMax - height[l];   // left side decides
                l++;
            } else {
                water += rightMax - height[r];
                r--;
            }
        }
        return water;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ For each bar, scanning left and right for the maximum — O(n²).

---

⬅️ [Previous: Boats to Save People](./012-boats-to-save-people.md) · [📋 Two Pointers list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
