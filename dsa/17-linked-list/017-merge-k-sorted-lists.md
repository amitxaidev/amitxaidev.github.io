# 17. Merge k Sorted Lists

**LeetCode 23** · 🔴 Hard · Pattern: **Min-heap of list heads**
🔗 Solve it here: [https://leetcode.com/problems/merge-k-sorted-lists/](https://leetcode.com/problems/merge-k-sorted-lists/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/017-merge-k-sorted-lists.html](https://amitxaidev.github.io/dsa/17-linked-list/017-merge-k-sorted-lists.html)

## The problem, in short

Merge k sorted linked lists into one sorted linked list.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The next node of the result is always the smallest current head among the k lists.

</details>

<details>
<summary>💡 Hint 2</summary>

A min-heap gives the smallest head in O(log k).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Push every non-null head into a PriorityQueue ordered by value. Repeatedly poll the smallest, append it, and push its next node if it exists.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/**
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode l : lists) if (l != null) pq.add(l);
        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();     // smallest current head
            tail.next = n;
            tail = n;
            if (n.next != null) pq.add(n.next);
        }
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(N log k), N = total nodes.
- **Space:** O(k).

## Common mistake

⚠️ Merging lists one after another into a growing result — O(N·k).

---

⬅️ [Previous: Flatten a Multilevel Doubly Linked List](./016-flatten-a-multilevel-doubly-linked-list.md) · [📋 Linked List list](./README.md) · [Next: Reverse Nodes in k-Group](./018-reverse-nodes-in-k-group.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
