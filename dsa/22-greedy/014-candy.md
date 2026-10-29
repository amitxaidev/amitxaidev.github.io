# 14. Candy

**LeetCode 135** · 🔴 Hard · Pattern: **Two passes**

## The problem, in short

Children stand in a line with ratings. Each gets at least one candy, and a child with a higher rating than a neighbour must get more than that neighbour. Return the minimum total.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/candy/](https://leetcode.com/problems/candy/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/014-candy.html](https://amitxaidev.github.io/dsa/22-greedy/014-candy.html)

## Understanding

**Really asking:** fewest candies so higher-rated kids get more than their neighbours.

**Why this works:** one pass fixes the left neighbour rule, one pass from the right fixes the right neighbour rule (take the max).

**Example:** ratings [1, 0, 2]
```text
left pass:  [1, 1, 2]
right pass: [2, 1, 2] → 5
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Handle the left-neighbour rule and the right-neighbour rule separately.

</details>

<details>
<summary>💡 Hint 2</summary>

Left to right: if rating rises, give one more than the left neighbour.

</details>

<details>
<summary>💡 Hint 3</summary>

Right to left: if rating rises, take the max of the current value and right neighbour + 1.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Two greedy passes over a candies array starting at 1. Taking the max in the second pass keeps the first rule satisfied.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);   // keep both rules
        int total = 0;
        for (int c : candies) total += c;
        return total;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Overwriting in the second pass instead of taking the max, which breaks the left rule.

---

⬅️ [Previous: Hand of Straights](./013-hand-of-straights.md) · [📋 Greedy list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
