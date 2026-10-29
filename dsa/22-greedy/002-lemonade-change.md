# 2. Lemonade Change

**LeetCode 860** · 🟢 Easy · Pattern: **Greedy change-making**
🔗 Solve it here: [https://leetcode.com/problems/lemonade-change/](https://leetcode.com/problems/lemonade-change/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/002-lemonade-change.html](https://amitxaidev.github.io/dsa/22-greedy/002-lemonade-change.html)

## The problem, in short

Lemonade costs $5. Customers pay with $5, $10 or $20 bills in order, and you start with no change. Decide whether you can give everyone correct change.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track how many $5 and $10 bills you hold.

</details>

<details>
<summary>💡 Hint 2</summary>

For a $20, prefer giving $10 + $5 over three $5s — $5 bills are more flexible.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Simulate. $5: keep it. $10: needs one $5. $20: use a $10 and a $5 if possible, else three $5s. Fail if neither works.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) five++;
            else if (b == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) { ten--; five--; }   // keep $5s when possible
                else if (five >= 3) five -= 3;
                else return false;
            }
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Paying a $20 with three $5s first, which runs out of $5s too early.

---

⬅️ [Previous: Assign Cookies](./001-assign-cookies.md) · [📋 Greedy list](./README.md) · [Next: Maximum Units on a Truck](./003-maximum-units-on-a-truck.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
