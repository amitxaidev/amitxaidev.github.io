# 1. Range Sum Query - Mutable

**LeetCode 307** · 🟡 Medium · Pattern: **Fenwick tree (BIT)**

## The problem, in short

Support two operations on an array: update one element, and return the sum of a range. Both must be fast.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/range-sum-query-mutable/](https://leetcode.com/problems/range-sum-query-mutable/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/26-segment-fenwick/001-range-sum-query-mutable.html](https://amitxaidev.github.io/dsa/26-segment-fenwick/001-range-sum-query-mutable.html)

## Understanding

**Really asking:** change single values and ask range sums, both fast.

**Why this works:** a Fenwick tree updates and sums prefixes in O(log n); a range sum is the difference of two prefix sums.

**Example:** [1, 3, 5]
```text
sum(0..2) = 9
update index 1 to 2 → add -1
sum(0..2) = 8
```

## Hints

<details>
<summary>💡 Hint 1</summary>

A prefix-sum array makes queries O(1) but updates O(n).

</details>

<details>
<summary>💡 Hint 2</summary>

A Fenwick tree (Binary Indexed Tree) does both in O(log n).

</details>

<details>
<summary>💡 Hint 3</summary>

i & -i is the lowest set bit — it decides how far each step jumps.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a 1-indexed tree array. add(i, delta) walks i += i & −i; prefix(i) walks i −= i & −i. update stores the old value to compute delta; sumRange = prefix(r + 1) − prefix(l).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class NumArray {
    private final int[] nums, tree;

    public NumArray(int[] nums) {
        this.nums = nums.clone();
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) add(i + 1, nums[i]);
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);   // add the difference
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefix(right + 1) - prefix(left);
    }

    private void add(int i, int delta) {
        for (; i < tree.length; i += i & -i) tree[i] += delta;
    }

    private int prefix(int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) s += tree[i];
        return s;
    }
}
```

</details>

## Complexity

- **Time:** O(log n) per update and query; O(n log n) to build.
- **Space:** O(n).

## Common mistake

⚠️ Passing the new value to add() instead of the difference from the old value.

---

[📋 Segment Tree, Fenwick & Sparse Table list](./README.md) · [Next: My Calendar I](./002-my-calendar-i.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
