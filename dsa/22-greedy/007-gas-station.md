# 7. Gas Station

**LeetCode 134** · 🟡 Medium · Pattern: **Reset start on deficit**
🔗 Solve it here: [https://leetcode.com/problems/gas-station/](https://leetcode.com/problems/gas-station/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/007-gas-station.html](https://amitxaidev.github.io/dsa/22-greedy/007-gas-station.html)

## The problem, in short

Stations form a circle. You get gas[i] at station i and spend cost[i] to reach the next. Return the starting station that lets you go all the way around once, or -1. The answer is unique if it exists.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If total gas &lt; total cost, it's impossible.

</details>

<details>
<summary>💡 Hint 2</summary>

If you run dry between start and i, none of the stations in between can be a valid start either. Restart at i + 1.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass tracking total balance and current tank. When the tank goes negative, set start = i + 1 and reset the tank.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {        // can't reach i+1 from start
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Simulating a full loop from every station — O(n²).

---

⬅️ [Previous: Jump Game II](./006-jump-game-ii.md) · [📋 Greedy list](./README.md) · [Next: Non-overlapping Intervals](./008-non-overlapping-intervals.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
