# 8. Maximum XOR With an Element From Array

**LeetCode 1707** · 🔴 Hard · Pattern: **Offline queries + binary trie**
🔗 Solve it here: [https://leetcode.com/problems/maximum-xor-with-an-element-from-array/](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/008-maximum-xor-with-an-element-from-array.html](https://amitxaidev.github.io/dsa/25-trie/008-maximum-xor-with-an-element-from-array.html)

## The problem, in short

For each query [x, m], return the maximum x XOR v over array values v ≤ m, or -1 if no value is ≤ m.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Answer queries offline: sort them by m.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort the array too, and insert values into a binary trie only while they are ≤ the current m.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Sort nums and the queries by m (keeping original indexes). Use a pointer to add nums ≤ m into the trie, then query the best XOR for x as in "Maximum XOR of Two Numbers". If the trie is empty, the answer is −1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private static class Node {
        Node[] child = new Node[2];
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int i = 0; i < q; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a][1], queries[b][1]));   // by m
        Node root = new Node();
        int[] ans = new int[q];
        int p = 0;
        for (int qi : order) {
            int x = queries[qi][0], m = queries[qi][1];
            while (p < nums.length && nums[p] <= m) insert(root, nums[p++]);
            ans[qi] = (p == 0) ? -1 : best(root, x);
        }
        return ans;
    }

    private void insert(Node root, int v) {
        Node cur = root;
        for (int b = 29; b >= 0; b--) {
            int bit = (v >> b) & 1;
            if (cur.child[bit] == null) cur.child[bit] = new Node();
            cur = cur.child[bit];
        }
    }

    private int best(Node root, int x) {
        Node cur = root;
        int xor = 0;
        for (int b = 29; b >= 0; b--) {
            int bit = (x >> b) & 1;
            if (cur.child[1 - bit] != null) {
                xor |= 1 << b;
                cur = cur.child[1 - bit];
            } else {
                cur = cur.child[bit];
            }
        }
        return xor;
    }
}
```

</details>

## Complexity

- **Time:** O((n + q) · 30 + n log n + q log q).
- **Space:** O(n · 30).

## Common mistake

⚠️ Answering queries in input order — you'd have to rebuild the trie for each m.

---

⬅️ [Previous: Word Search II](./007-word-search-ii.md) · [📋 Trie list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
