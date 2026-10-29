# 4. How Many Numbers Are Smaller Than the Current Number

**LeetCode 1365** · 🟢 Easy · Pattern: **Counting array**

## The problem, in short

For every element, report how many other elements in the array are strictly smaller than it. Values are between 0 and 100.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/004-how-many-numbers-are-smaller-than-the-current-number.html](https://amitxaidev.github.io/dsa/01-complexity/004-how-many-numbers-are-smaller-than-the-current-number.html)

## Understanding

**Really asking:** for each number, how many others are strictly smaller? Values are only 0..100, which is the hint for a faster way.

**Why this works:** count how often each value appears, then a running total of those counts tells you "how many values are below v" for every v at once.

**Example:** nums = [8, 1, 2, 2, 3]
```text
counts:   1→1, 2→2, 3→1, 8→1
below 1 = 0, below 2 = 1, below 3 = 3, below 8 = 4
answer:  8→4, 1→0, 2→1, 2→1, 3→3   →  [4, 0, 1, 1, 3]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The brute force compares every pair: O(n²). It passes, but can you do better using the small value range?

</details>

<details>
<summary>💡 Hint 2</summary>

Count how often each value 0..100 appears, then build a running total of those counts.

</details>

<details>
<summary>💡 Hint 3</summary>

The running total just before value v tells you how many elements are smaller than v.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build a frequency array of size 101, then turn it into a prefix count where less[v] = number of elements with value below v. Each answer is a lookup. This trades a tiny fixed array for going from O(n²) to O(n + 101).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[102];
        for (int x : nums) freq[x + 1]++;           // shift by one so freq[v] ends as "count of values < v"
        for (int v = 1; v < freq.length; v++) freq[v] += freq[v - 1];
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) ans[i] = freq[nums[i]];
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n + R) where R = 101 is the value range.
- **Space:** O(R).

## Common mistake

⚠️ Using the prefix count including v itself, which also counts equal elements. Use the total of values strictly less than v.

---

⬅️ [Previous: Find Numbers with Even Number of Digits](./003-find-numbers-with-even-number-of-digits.md) · [📋 Time & Space Complexity list](./README.md) · [Next: Final Value of Variable After Performing Operations](./005-final-value-of-variable-after-performing-operations.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
