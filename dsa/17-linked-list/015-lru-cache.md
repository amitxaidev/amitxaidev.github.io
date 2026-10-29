# 15. LRU Cache

**LeetCode 146** · 🟡 Medium · Pattern: **HashMap + doubly linked list**
🔗 Solve it here: [https://leetcode.com/problems/lru-cache/](https://leetcode.com/problems/lru-cache/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/015-lru-cache.html](https://amitxaidev.github.io/dsa/17-linked-list/015-lru-cache.html)

## The problem, in short

Design a fixed-capacity cache with get and put in O(1). When full, put evicts the least recently used key.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A HashMap finds a key in O(1). A doubly linked list keeps usage order and removes any node in O(1).

</details>

<details>
<summary>💡 Hint 2</summary>

Most recent at the head, least recent at the tail. Sentinel head/tail nodes remove edge cases.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

map: key → node. get: if present, move the node to the front and return its value. put: update and move to front, or insert a new node at the front; if over capacity, remove the node before the tail sentinel and delete its key from the map.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class LRUCache {
    private static class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0), tail = new Node(0, 0);   // sentinels

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        unlink(n);
        addFront(n);          // now the most recently used
        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.val = value;
            unlink(n);
            addFront(n);
            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;   // least recently used
            unlink(lru);
            map.remove(lru.key);
        }
        n = new Node(key, value);
        addFront(n);
        map.put(key, n);
    }

    private void unlink(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addFront(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }
}
```

</details>

## Complexity

- **Time:** O(1) per operation.
- **Space:** O(capacity).

## Common mistake

⚠️ Forgetting to remove the evicted key from the HashMap, so the map keeps growing and returns stale nodes.

---

⬅️ [Previous: Copy List with Random Pointer](./014-copy-list-with-random-pointer.md) · [📋 Linked List list](./README.md) · [Next: Flatten a Multilevel Doubly Linked List](./016-flatten-a-multilevel-doubly-linked-list.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
