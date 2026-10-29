# 14. Cheapest Flights Within K Stops

**LeetCode 787** · 🟡 Medium · Pattern: **Bellman-Ford with k+1 rounds**
🔗 Solve it here: [https://leetcode.com/problems/cheapest-flights-within-k-stops/](https://leetcode.com/problems/cheapest-flights-within-k-stops/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/014-cheapest-flights-within-k-stops.html](https://amitxaidev.github.io/dsa/23-graphs/014-cheapest-flights-within-k-stops.html)

## The problem, in short

Find the cheapest price from src to dst using at most k stops (k + 1 flights), or -1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Bellman-Ford's i-th round finds the best paths using at most i edges.

</details>

<details>
<summary>💡 Hint 2</summary>

Run exactly k + 1 rounds, and relax from a copy of the previous round's prices so a round can't chain several flights.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

prices[src] = 0. Repeat k + 1 times: copy the array, then for every flight (u, v, w) with prices[u] finite, update copy[v] = min(copy[v], prices[u] + w). Swap.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int round = 0; round <= k; round++) {
            int[] next = prices.clone();                   // read last round, write this round
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (prices[u] != Integer.MAX_VALUE && prices[u] + w < next[v]) next[v] = prices[u] + w;
            }
            prices = next;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
```

</details>

## Complexity

- **Time:** O(k · E).
- **Space:** O(V).

## Common mistake

⚠️ Updating the same array within a round, which lets one round use more than one extra flight.

---

⬅️ [Previous: Path With Minimum Effort](./013-path-with-minimum-effort.md) · [📋 Graphs list](./README.md) · [Next: Find the City With the Smallest Number of Neighbors at a Threshold Distance](./015-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
