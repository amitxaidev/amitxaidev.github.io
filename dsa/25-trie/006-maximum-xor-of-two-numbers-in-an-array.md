# 6. Maximum XOR of Two Numbers in an Array

**LeetCode 421** · 🟡 Medium · Pattern: **Binary trie**
🔗 Solve it here: [https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/006-maximum-xor-of-two-numbers-in-an-array.html](https://amitxaidev.github.io/dsa/25-trie/006-maximum-xor-of-two-numbers-in-an-array.html)

## The problem, in short

Return the maximum value of nums[i] XOR nums[j] over all pairs.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Store numbers bit by bit (from bit 30 down to 0) in a trie with two children per node.

</details>

<details>
<summary>💡 Hint 2</summary>

To maximise XOR with x, at each bit prefer the child with the opposite bit.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Insert each number, and before or after inserting, walk the trie greedily choosing the opposite bit when it exists; accumulate the XOR bits. Track the best.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private static class Node {
        Node[] child = new Node[2];
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int best = 0;
        for (int x : nums) {
            Node ins = root, q = root;
            int xor = 0;
            for (int b = 30; b >= 0; b--) {
                int bit = (x >> b) & 1;
                if (ins.child[bit] == null) ins.child[bit] = new Node();
                ins = ins.child[bit];
                if (q.child[1 - bit] != null) {      // opposite bit gives a 1 here
                    xor |= 1 << b;
                    q = q.child[1 - bit];
                } else {
                    q = q.child[bit];
                }
            }
            best = Math.max(best, xor);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n · 31).
- **Space:** O(n · 31).

## Common mistake

⚠️ Walking from the lowest bit up — the highest bits matter most, so go from the top.

---

⬅️ [Previous: Longest Word in Dictionary](./005-longest-word-in-dictionary.md) · [📋 Trie list](./README.md) · [Next: Word Search II](./007-word-search-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
