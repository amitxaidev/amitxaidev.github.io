# 10. Course Schedule II

**LeetCode 210** · 🟡 Medium · Pattern: **Topological sort (Kahn)**

## The problem, in short

Same prerequisites as Course Schedule. Return any valid order to take all courses, or an empty array if impossible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/course-schedule-ii/](https://leetcode.com/problems/course-schedule-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/010-course-schedule-ii.html](https://amitxaidev.github.io/dsa/23-graphs/010-course-schedule-ii.html)

## Understanding

**Really asking:** give a valid order to take all courses.

**Why this works:** the order in which Kahn's algorithm removes courses is a topological order.

**Example:** 4 courses, 1 and 2 need 0, 3 needs 1 and 2
```text
take 0 → then 1, 2 → then 3 → [0, 1, 2, 3]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Kahn's algorithm produces a topological order as it goes.

</details>

<details>
<summary>💡 Hint 2</summary>

If the order has fewer than n courses, there's a cycle.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Same as Course Schedule, but write each polled course into the result array.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.offer(i);
        int[] order = new int[numCourses];
        int k = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[k++] = u;
            for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
        }
        return k == numCourses ? order : new int[0];
    }
}
```

</details>

## Complexity

- **Time:** O(V + E).
- **Space:** O(V + E).

## Common mistake

⚠️ Returning a partial order when a cycle exists — return an empty array instead.

---

⬅️ [Previous: Course Schedule](./009-course-schedule.md) · [📋 Graphs list](./README.md) · [Next: Is Graph Bipartite?](./011-is-graph-bipartite.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
