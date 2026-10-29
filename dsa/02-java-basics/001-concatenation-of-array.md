# 1. Concatenation of Array

**LeetCode 1929** · 🟢 Easy · Pattern: **Array basics**
🔗 Solve it here: [https://leetcode.com/problems/concatenation-of-array/](https://leetcode.com/problems/concatenation-of-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/001-concatenation-of-array.html](https://amitxaidev.github.io/dsa/02-java-basics/001-concatenation-of-array.html)

## The problem, in short

Return an array of length 2n that is the input array followed by itself.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Create a new int array of size 2 * n.

</details>

<details>
<summary>💡 Hint 2</summary>

Position i and position i + n hold the same value.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Allocate the result once and fill both halves in a single loop. Java arrays have a fixed size, so you must know the length when you create it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // first copy
            ans[i + n] = nums[i];   // second copy
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the output.

## Common mistake

⚠️ Trying to "append" to a Java int[] — arrays can't grow. Allocate the full size first.

---

[📋 Java Basics for DSA list](./README.md) · [Next: Shuffle the Array](./002-shuffle-the-array.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
