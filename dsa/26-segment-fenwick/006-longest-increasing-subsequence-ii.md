# 6. Longest Increasing Subsequence II

**LeetCode 2407** · 🔴 Hard · Pattern: **Segment tree over values (range max)**
🔗 Solve it here: [https://leetcode.com/problems/longest-increasing-subsequence-ii/](https://leetcode.com/problems/longest-increasing-subsequence-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/26-segment-fenwick/006-longest-increasing-subsequence-ii.html](https://amitxaidev.github.io/dsa/26-segment-fenwick/006-longest-increasing-subsequence-ii.html)

## The problem, in short

Find the longest strictly increasing subsequence where each pair of neighbouring elements differs by at most k.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

best[v] = longest valid subsequence ending with value v.

</details>

<details>
<summary>💡 Hint 2</summary>

For a new value x, you need max best[v] for v in [x − k, x − 1] — a range maximum query.

</details>

<details>
<summary>💡 Hint 3</summary>

Values are up to 10^5, so a segment tree indexed by value works directly.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each x: len = 1 + query(max(1, x − k), x − 1); then point-update position x with len (keep the max). Track the overall best.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private int size;
    private int[] tree;

    public int lengthOfLIS(int[] nums, int k) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);
        size = 1;
        while (size <= max) size <<= 1;
        tree = new int[2 * size];               // iterative segment tree, leaves at size..2*size-1
        int best = 0;
        for (int x : nums) {
            int len = 1 + query(Math.max(1, x - k), x - 1);
            update(x, len);
            best = Math.max(best, len);
        }
        return best;
    }

    private void update(int pos, int val) {
        int i = pos + size;
        tree[i] = Math.max(tree[i], val);
        for (i >>= 1; i >= 1; i >>= 1) tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
    }

    // max over [l, r]
    private int query(int l, int r) {
        if (l > r) return 0;
        int res = 0;
        for (l += size, r += size + 1; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res = Math.max(res, tree[l++]);
            if ((r & 1) == 1) res = Math.max(res, tree[--r]);
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n log M).
- **Space:** O(M).

## Common mistake

⚠️ Using the O(n²) LIS DP — too slow for n = 10^5.

---

⬅️ [Previous: Falling Squares](./005-falling-squares.md) · [📋 Segment Tree, Fenwick & Sparse Table list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
