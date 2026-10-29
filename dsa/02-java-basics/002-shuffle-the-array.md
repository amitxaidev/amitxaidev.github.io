# 2. Shuffle the Array

**LeetCode 1470** · 🟢 Easy · Pattern: **Index arithmetic**

## The problem, in short

The array holds x1..xn followed by y1..yn. Return it interleaved as x1, y1, x2, y2, ...

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/shuffle-the-array/](https://leetcode.com/problems/shuffle-the-array/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/002-shuffle-the-array.html](https://amitxaidev.github.io/dsa/02-java-basics/002-shuffle-the-array.html)

## Understanding

**Really asking:** take the first half (x's) and the second half (y's) and zip them together: x1, y1, x2, y2…

**Why this works:** x_i lives at index i and y_i at index i + n; in the answer they go to 2i and 2i + 1.

**Example:** nums = [2, 5, 1, 3, 4, 7], n = 3
```text
x = [2, 5, 1], y = [3, 4, 7]
i=0 → ans[0]=2, ans[1]=3
i=1 → ans[2]=5, ans[3]=4
i=2 → ans[4]=1, ans[5]=7
ans = [2, 3, 5, 4, 1, 7]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

x_i is at index i and y_i is at index i + n.

</details>

<details>
<summary>💡 Hint 2</summary>

In the answer, x_i goes to 2i and y_i goes to 2i + 1.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill a new array using the index formulas. Getting comfortable with index arithmetic like 2i and 2i+1 pays off later in heaps and segment trees.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];         // x_i
            ans[2 * i + 1] = nums[i + n]; // y_i
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

⚠️ Looping i up to 2n instead of n, which reads past the first half.

---

⬅️ [Previous: Concatenation of Array](./001-concatenation-of-array.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Fizz Buzz](./003-fizz-buzz.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
