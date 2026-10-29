# 2. Range Sum Query - Immutable

**LeetCode 303** · 🟢 Easy · Pattern: **Prefix array**
🔗 Solve it here: [https://leetcode.com/problems/range-sum-query-immutable/](https://leetcode.com/problems/range-sum-query-immutable/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/002-range-sum-query-immutable.html](https://amitxaidev.github.io/dsa/06-prefix-sum/002-range-sum-query-immutable.html)

## The problem, in short

Design a class that answers many queries "sum of nums from index left to right" on a fixed array.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Summing each range every time is O(n) per query.

</details>

<details>
<summary>💡 Hint 2</summary>

Store prefix[i] = sum of the first i elements (prefix[0] = 0).

</details>

<details>
<summary>💡 Hint 3</summary>

sum(left..right) = prefix[right + 1] - prefix[left].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build a prefix array of size n + 1 once in the constructor. Each query is a single subtraction.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class NumArray {
    private final int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
```

</details>

## Complexity

- **Time:** O(n) to build, O(1) per query.
- **Space:** O(n).

## Common mistake

⚠️ Using a prefix array of size n and then special-casing left = 0. The extra leading 0 removes the edge case.

---

⬅️ [Previous: Find the Highest Altitude](./001-find-the-highest-altitude.md) · [📋 Prefix Sum list](./README.md) · [Next: Find Pivot Index](./003-find-pivot-index.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
