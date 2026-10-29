# 12. Bitwise AND of Numbers Range

**LeetCode 201** · 🟡 Medium · Pattern: **Common prefix**
🔗 Solve it here: [https://leetcode.com/problems/bitwise-and-of-numbers-range/](https://leetcode.com/problems/bitwise-and-of-numbers-range/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/04-bit-manipulation/012-bitwise-and-of-numbers-range.html](https://amitxaidev.github.io/dsa/04-bit-manipulation/012-bitwise-and-of-numbers-range.html)

## The problem, in short

Return the bitwise AND of every integer from left to right inclusive.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Any bit that flips somewhere in the range becomes 0 in the AND.

</details>

<details>
<summary>💡 Hint 2</summary>

Only the common binary prefix of left and right survives.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Shift both numbers right until they are equal, counting the shifts. Then shift the common prefix back left. (Or repeatedly do right &= right - 1 while right > left.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left != right) {   // strip bits until only the shared prefix remains
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
```

</details>

## Complexity

- **Time:** O(32) = O(1).
- **Space:** O(1).

## Common mistake

⚠️ Looping from left to right and ANDing every number — the range can have two billion numbers.

---

⬅️ [Previous: Sum of Two Integers](./011-sum-of-two-integers.md) · [📋 Bit Manipulation list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
