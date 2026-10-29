# 5. Final Value of Variable After Performing Operations

**LeetCode 2011** · 🟢 Easy · Pattern: **Simulation**

## The problem, in short

A variable X starts at 0. You get a list of operations, each one of "++X", "X++", "--X" or "X--". Return X after applying all of them.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/final-value-of-variable-after-performing-operations/](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/005-final-value-of-variable-after-performing-operations.html](https://amitxaidev.github.io/dsa/01-complexity/005-final-value-of-variable-after-performing-operations.html)

## Understanding

**Really asking:** start at 0, add 1 for every "++" and subtract 1 for every "--". The position of the ++ doesn't matter.

**Why this works:** the middle character of every operation is the sign, so one check per operation is enough. Constant work per item × n items = O(n).

**Example:** ["--X", "X++", "X++"]
```text
"--X" → middle '-' → X = -1
"X++" → middle '+' → X = 0
"X++" → middle '+' → X = 1
```

## Hints

<details>
<summary>💡 Hint 1</summary>

You only need to know whether an operation increments or decrements.

</details>

<details>
<summary>💡 Hint 2</summary>

The middle character (index 1) is always '+' or '-'.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Loop once and look at character 1 of each operation. Constant work per operation gives O(n). It's a reminder that work done per element (here O(1)) multiplies with the loop size.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.charAt(1) == '+') x++;   // "++X" and "X++" both have '+' in the middle
            else x--;
        }
        return x;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Comparing strings with == in Java instead of equals(). Checking a single char avoids the issue entirely.

---

⬅️ [Previous: How Many Numbers Are Smaller Than the Current Number](./004-how-many-numbers-are-smaller-than-the-current-number.md) · [📋 Time & Space Complexity list](./README.md) · [Next: Number of Good Pairs](./006-number-of-good-pairs.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
