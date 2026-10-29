# 9. Course Schedule

**LeetCode 207** · 🟡 Medium · Pattern: **Cycle detection with Kahn's algorithm**
🔗 Solve it here: [https://leetcode.com/problems/course-schedule/](https://leetcode.com/problems/course-schedule/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/009-course-schedule.html](https://amitxaidev.github.io/dsa/23-graphs/009-course-schedule.html)

## The problem, in short

Courses have prerequisite pairs [a, b] meaning b must come before a. Decide whether all courses can be finished.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

This is "does the directed graph have a cycle?"

</details>

<details>
<summary>💡 Hint 2</summary>

Kahn's algorithm: repeatedly take courses with no remaining prerequisites.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build edges b → a and in-degrees. Queue all courses with in-degree 0; when a course is taken, reduce its neighbours' in-degrees. If all n courses get taken, there's no cycle.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);   // b before a
            indeg[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.offer(i);
        int taken = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            taken++;
            for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
        }
        return taken == numCourses;   // leftover courses sit on a cycle
    }
}
```

</details>

## Complexity

- **Time:** O(V + E).
- **Space:** O(V + E).

## Common mistake

⚠️ Reversing the edge direction — it still detects cycles here, but gives the wrong order in Course Schedule II.

---

⬅️ [Previous: Clone Graph](./008-clone-graph.md) · [📋 Graphs list](./README.md) · [Next: Course Schedule II](./010-course-schedule-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
