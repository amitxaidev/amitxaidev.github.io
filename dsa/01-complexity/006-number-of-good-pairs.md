# 6. Number of Good Pairs

**LeetCode 1512** · 🟢 Easy · Pattern: **Counting**

## The problem, in short

Count pairs of indexes (i, j) with i &lt; j where nums[i] equals nums[j].

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/number-of-good-pairs/](https://leetcode.com/problems/number-of-good-pairs/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/006-number-of-good-pairs.html](https://amitxaidev.github.io/dsa/01-complexity/006-number-of-good-pairs.html)

## Understanding

**Really asking:** count pairs of equal values (i before j).

**Why this works:** when a value appears for the k-th time, it makes a new pair with each of the k-1 earlier copies. Keep a count per value and add it before increasing.

**Example:** nums = [1, 2, 3, 1, 1, 3]
```text
1: seen 0 before → +0   (seen[1]=1)
2: +0, 3: +0
1: seen 1 before → +1   (seen[1]=2)
1: seen 2 before → +2   (seen[1]=3)
3: seen 1 before → +1
total = 4
```

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

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
