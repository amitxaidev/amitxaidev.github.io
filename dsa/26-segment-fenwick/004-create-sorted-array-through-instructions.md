# 4. Create Sorted Array through Instructions

**LeetCode 1649** · 🔴 Hard · Pattern: **Fenwick tree counting**
🔗 Solve it here: [https://leetcode.com/problems/create-sorted-array-through-instructions/](https://leetcode.com/problems/create-sorted-array-through-instructions/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/26-segment-fenwick/004-create-sorted-array-through-instructions.html](https://amitxaidev.github.io/dsa/26-segment-fenwick/004-create-sorted-array-through-instructions.html)

## The problem, in short

Insert numbers one by one into a sorted container. Each insertion costs min(count of existing numbers strictly less, count strictly greater). Return the total cost modulo 1e9+7.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You need "how many inserted so far are &lt; x" and "> x" quickly.

</details>

<details>
<summary>💡 Hint 2</summary>

Values are at most 10^5, so a Fenwick tree indexed by value counts them.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

less = prefix(x − 1); greater = inserted − prefix(x). Add min to the cost, then add 1 at x.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int createSortedArray(int[] instructions) {
        final int MOD = 1_000_000_007;
        int max = 0;
        for (int x : instructions) max = Math.max(max, x);
        int[] tree = new int[max + 1];
        long cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];
            int less = prefix(tree, x - 1);
            int greater = i - prefix(tree, x);        // i numbers inserted so far
            cost += Math.min(less, greater);
            for (int j = x; j <= max; j += j & -j) tree[j]++;
        }
        return (int) (cost % MOD);
    }

    private int prefix(int[] tree, int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) s += tree[i];
        return s;
    }
}
```

</details>

## Complexity

- **Time:** O(n log M), M = max value.
- **Space:** O(M).

## Common mistake

⚠️ Counting "greater" as inserted − prefix(x − 1), which wrongly includes equal values.

---

⬅️ [Previous: Count of Range Sum](./003-count-of-range-sum.md) · [📋 Segment Tree, Fenwick & Sparse Table list](./README.md) · [Next: Falling Squares](./005-falling-squares.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
