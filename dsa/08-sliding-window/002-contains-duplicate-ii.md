# 2. Contains Duplicate II

**LeetCode 219** · 🟢 Easy · Pattern: **Fixed window + HashSet**

## The problem, in short

Decide whether two equal values exist whose indexes are at most k apart.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/contains-duplicate-ii/](https://leetcode.com/problems/contains-duplicate-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/002-contains-duplicate-ii.html](https://amitxaidev.github.io/dsa/08-sliding-window/002-contains-duplicate-ii.html)

## Understanding

**Really asking:** are there two equal values at most k apart?

**Why this works:** only the last k values matter. Keep them in a set and drop the one that falls out.

**Example:** [1, 2, 3, 1], k = 3
```text
window {1, 2, 3}
next 1 is already in the window → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Only the last k elements matter for the current index.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep them in a HashSet and drop the one that falls out of range.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Slide a window of size k as a set. If the current value is already in the set, return true. Add it, and remove nums[i - k] once the window is too big.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!window.add(nums[i])) return true;      // already inside the window
            if (window.size() > k) window.remove(nums[i - k]);
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(k).

## Common mistake

⚠️ Removing the old element before checking, with an off-by-one that makes the window k - 1 wide.

---

⬅️ [Previous: Maximum Average Subarray I](./001-maximum-average-subarray-i.md) · [📋 Sliding Window list](./README.md) · [Next: Longest Substring Without Repeating Characters](./003-longest-substring-without-repeating-characters.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
