# 14. Subarrays with K Different Integers

**LeetCode 992** · 🔴 Hard · Pattern: **atMost(k) − atMost(k−1)**
🔗 Solve it here: [https://leetcode.com/problems/subarrays-with-k-different-integers/](https://leetcode.com/problems/subarrays-with-k-different-integers/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/014-subarrays-with-k-different-integers.html](https://amitxaidev.github.io/dsa/08-sliding-window/014-subarrays-with-k-different-integers.html)

## The problem, in short

Count subarrays that contain exactly k distinct integers.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Exactly k = at most k − at most (k − 1).

</details>

<details>
<summary>💡 Hint 2</summary>

Counting "at most k distinct" is a standard variable window with a count map.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

atMost(k): expand right, track counts and number of distinct values; while distinct > k, shrink. Add r - left + 1 for each r. Answer = atMost(k) − atMost(k − 1). Values are at most n, so an int array works as the map.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int left = 0, distinct = 0, total = 0;
        for (int r = 0; r < nums.length; r++) {
            if (count[nums[r]]++ == 0) distinct++;
            while (distinct > k) {
                if (--count[nums[left++]] == 0) distinct--;
            }
            total += r - left + 1;
        }
        return total;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Trying to count exactly-k windows directly with one window — you miss subarrays that start in the middle of a run.

---

⬅️ [Previous: Minimum Window Substring](./013-minimum-window-substring.md) · [📋 Sliding Window list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
