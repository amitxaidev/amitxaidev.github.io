# 6. Happy Number

**LeetCode 202** · 🟢 Easy · Pattern: **HashSet cycle detection**
🔗 Solve it here: [https://leetcode.com/problems/happy-number/](https://leetcode.com/problems/happy-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/006-happy-number.html](https://amitxaidev.github.io/dsa/16-hashing/006-happy-number.html)

## The problem, in short

Replace a number by the sum of the squares of its digits, again and again. It's "happy" if this reaches 1; otherwise it loops forever. Decide which.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If you see a number twice, you're in a loop.

</details>

<details>
<summary>💡 Hint 2</summary>

Store seen numbers in a HashSet (or use slow/fast pointers).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep computing the next value until it's 1 (happy) or already in the set (loop).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && seen.add(n)) {   // add fails on a repeat
            int next = 0;
            while (n > 0) {
                int d = n % 10;
                next += d * d;
                n /= 10;
            }
            n = next;
        }
        return n == 1;
    }
}
```

</details>

## Complexity

- **Time:** O(log n) per step; the sequence quickly drops below a few hundred.
- **Space:** O(log n).

## Common mistake

⚠️ Looping without detecting repeats — the program never ends for unhappy numbers.

---

⬅️ [Previous: Unique Number of Occurrences](./005-unique-number-of-occurrences.md) · [📋 Hashing list](./README.md) · [Next: Longest Consecutive Sequence](./007-longest-consecutive-sequence.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
