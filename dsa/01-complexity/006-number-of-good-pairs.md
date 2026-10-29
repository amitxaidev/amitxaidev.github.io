# 6. Number of Good Pairs

**LeetCode 1512** · 🟢 Easy · Pattern: **Counting**
🔗 Solve it here: [https://leetcode.com/problems/number-of-good-pairs/](https://leetcode.com/problems/number-of-good-pairs/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/006-number-of-good-pairs.html](https://amitxaidev.github.io/dsa/01-complexity/006-number-of-good-pairs.html)

## The problem, in short

Count pairs of indexes (i, j) with i &lt; j where nums[i] equals nums[j].

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Brute force checks every pair with two loops — that's O(n²).

</details>

<details>
<summary>💡 Hint 2</summary>

When you see a value for the k-th time, it forms a new pair with each of the k-1 earlier copies.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a count of each value seen so far. Before increasing the count of the current value, add that count to the answer. One pass, O(n) — the same answer as the O(n²) double loop, which is the whole point of complexity analysis.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] seen = new int[101];
        int pairs = 0;
        for (int x : nums) {
            pairs += seen[x];   // pair with every earlier copy
            seen[x]++;
        }
        return pairs;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(R) for the counts (values are at most 100).

## Common mistake

⚠️ Incrementing the count before adding it, which counts each element as a pair with itself.

---

⬅️ [Previous: Final Value of Variable After Performing Operations](./005-final-value-of-variable-after-performing-operations.md) · [📋 Time & Space Complexity list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
