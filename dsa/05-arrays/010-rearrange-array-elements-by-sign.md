# 10. Rearrange Array Elements by Sign

**LeetCode 2149** · 🟡 Medium · Pattern: **Two write indexes**
🔗 Solve it here: [https://leetcode.com/problems/rearrange-array-elements-by-sign/](https://leetcode.com/problems/rearrange-array-elements-by-sign/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/010-rearrange-array-elements-by-sign.html](https://amitxaidev.github.io/dsa/05-arrays/010-rearrange-array-elements-by-sign.html)

## The problem, in short

The array has equal numbers of positives and negatives. Rearrange so signs alternate starting with a positive, keeping the original relative order within each sign.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Positives go to even indexes, negatives to odd indexes.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep one write index for each sign and advance it by 2.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Make a result array. Scan nums; put each positive at pos (then pos += 2) and each negative at neg (then neg += 2). Order inside each group is preserved automatically.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 1;
        for (int x : nums) {
            if (x > 0) { res[pos] = x; pos += 2; }
            else       { res[neg] = x; neg += 2; }
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the output.

## Common mistake

⚠️ Trying to swap in place — that breaks the required relative order.

---

⬅️ [Previous: Next Permutation](./009-next-permutation.md) · [📋 Arrays list](./README.md) · [Next: Find All Duplicates in an Array](./011-find-all-duplicates-in-an-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
