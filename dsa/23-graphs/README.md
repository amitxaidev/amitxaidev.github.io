# 23 · Graphs

BFS/DFS, islands, cycles, topo sort, bipartite, shortest paths, MST, DSU, SCC and bridges.

📺 **Watch first:** Ep 74, Ep 75, Ep 76, Ep 77, Ep 78, Ep 79, Ep 80, Ep 81, Ep 82, Ep 83, Ep 84, Ep 85 of the Compiled Canvas DSA course ([full playlist](https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg)).  
🌐 **Practise on the website** (tick problems, filter, reveal hints one by one): https://amitxaidev.github.io/dsa/23-graphs/  
🧮 **21 problems** · 🟢 2 Easy · 🟡 16 Medium · 🔴 3 Hard

## Understand the topic

A graph is nodes connected by edges, like cities and roads. Store it as an adjacency list (List&lt;List&lt;Integer>>), or treat a grid as a graph where each cell connects to its four neighbours. Always keep a visited array.

Pick the tool by the question. To explore or count components, use BFS or DFS. For the shortest path with equal edges, use BFS. For an order with prerequisites, use topological sort (Kahn's algorithm). For shortest paths with weights, use Dijkstra, or Bellman-Ford when there's a limit on edges. For all pairs, use Floyd-Warshall. To connect everything cheaply, use an MST (Prim or Kruskal). For "are these connected?" while adding edges, use Union-Find. For edges whose removal disconnects the graph, use Tarjan's bridges.

## How to use this list

1. Watch the episode above.
2. Go in order: the list runs easy → medium → hard.
3. Open the problem page here, read the short summary, then solve it on LeetCode.
4. Stuck for 15+ minutes? Open **one** hint at a time. Still stuck? Open the approach, then the Java answer.
5. Tick ⬜ → ✅ in your own fork as you go.

## Problems

| # | LeetCode | Link | Difficulty | Pattern | Done |
|---|---|---|---|---|---|
| 1 | [1971. Find if Path Exists in Graph](./001-find-if-path-exists-in-graph.md) | [Solve ↗](https://leetcode.com/problems/find-if-path-exists-in-graph/) | 🟢 Easy | Adjacency list + BFS | ⬜ |
| 2 | [733. Flood Fill](./002-flood-fill.md) | [Solve ↗](https://leetcode.com/problems/flood-fill/) | 🟢 Easy | Grid DFS | ⬜ |
| 3 | [200. Number of Islands](./003-number-of-islands.md) | [Solve ↗](https://leetcode.com/problems/number-of-islands/) | 🟡 Medium | Connected components on a grid | ⬜ |
| 4 | [547. Number of Provinces](./004-number-of-provinces.md) | [Solve ↗](https://leetcode.com/problems/number-of-provinces/) | 🟡 Medium | Connected components (adjacency matrix) | ⬜ |
| 5 | [695. Max Area of Island](./005-max-area-of-island.md) | [Solve ↗](https://leetcode.com/problems/max-area-of-island/) | 🟡 Medium | DFS returning size | ⬜ |
| 6 | [994. Rotting Oranges](./006-rotting-oranges.md) | [Solve ↗](https://leetcode.com/problems/rotting-oranges/) | 🟡 Medium | Multi-source BFS | ⬜ |
| 7 | [417. Pacific Atlantic Water Flow](./007-pacific-atlantic-water-flow.md) | [Solve ↗](https://leetcode.com/problems/pacific-atlantic-water-flow/) | 🟡 Medium | Reverse BFS/DFS from the oceans | ⬜ |
| 8 | [133. Clone Graph](./008-clone-graph.md) | [Solve ↗](https://leetcode.com/problems/clone-graph/) | 🟡 Medium | DFS with old → new map | ⬜ |
| 9 | [207. Course Schedule](./009-course-schedule.md) | [Solve ↗](https://leetcode.com/problems/course-schedule/) | 🟡 Medium | Cycle detection with Kahn's algorithm | ⬜ |
| 10 | [210. Course Schedule II](./010-course-schedule-ii.md) | [Solve ↗](https://leetcode.com/problems/course-schedule-ii/) | 🟡 Medium | Topological sort (Kahn) | ⬜ |
| 11 | [785. Is Graph Bipartite?](./011-is-graph-bipartite.md) | [Solve ↗](https://leetcode.com/problems/is-graph-bipartite/) | 🟡 Medium | 2-colouring with BFS | ⬜ |
| 12 | [743. Network Delay Time](./012-network-delay-time.md) | [Solve ↗](https://leetcode.com/problems/network-delay-time/) | 🟡 Medium | Dijkstra | ⬜ |
| 13 | [1631. Path With Minimum Effort](./013-path-with-minimum-effort.md) | [Solve ↗](https://leetcode.com/problems/path-with-minimum-effort/) | 🟡 Medium | Dijkstra on a grid (minimax) | ⬜ |
| 14 | [787. Cheapest Flights Within K Stops](./014-cheapest-flights-within-k-stops.md) | [Solve ↗](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | 🟡 Medium | Bellman-Ford with k+1 rounds | ⬜ |
| 15 | [1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance](./015-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance.md) | [Solve ↗](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | 🟡 Medium | Floyd-Warshall | ⬜ |
| 16 | [1584. Min Cost to Connect All Points](./016-min-cost-to-connect-all-points.md) | [Solve ↗](https://leetcode.com/problems/min-cost-to-connect-all-points/) | 🟡 Medium | Prim's MST (dense graph) | ⬜ |
| 17 | [684. Redundant Connection](./017-redundant-connection.md) | [Solve ↗](https://leetcode.com/problems/redundant-connection/) | 🟡 Medium | Union-Find | ⬜ |
| 18 | [721. Accounts Merge](./018-accounts-merge.md) | [Solve ↗](https://leetcode.com/problems/accounts-merge/) | 🟡 Medium | Union-Find on emails | ⬜ |
| 19 | [127. Word Ladder](./019-word-ladder.md) | [Solve ↗](https://leetcode.com/problems/word-ladder/) | 🔴 Hard | BFS on implicit graph | ⬜ |
| 20 | [1192. Critical Connections in a Network](./020-critical-connections-in-a-network.md) | [Solve ↗](https://leetcode.com/problems/critical-connections-in-a-network/) | 🔴 Hard | Tarjan's bridges | ⬜ |
| 21 | [778. Swim in Rising Water](./021-swim-in-rising-water.md) | [Solve ↗](https://leetcode.com/problems/swim-in-rising-water/) | 🔴 Hard | Dijkstra (minimax) on a grid | ⬜ |

---

[🏠 Back to the DSA in Java course](../README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
