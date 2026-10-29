# 16. Flatten a Multilevel Doubly Linked List

**LeetCode 430** · 🟡 Medium · Pattern: **Doubly linked list splicing**
🔗 Solve it here: [https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/016-flatten-a-multilevel-doubly-linked-list.html](https://amitxaidev.github.io/dsa/17-linked-list/016-flatten-a-multilevel-doubly-linked-list.html)

## The problem, in short

A doubly linked list's nodes may have a child pointer to another doubly linked list (which may have children too). Flatten everything into one level, placing each child list right after its parent node.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

When a node has a child, the child list goes between the node and its next.

</details>

<details>
<summary>💡 Hint 2</summary>

Find the tail of the child list, then reconnect next/prev pointers in both directions.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk the list. On a node with a child: remember next, link node ↔ child, walk to the child list's tail, link tail ↔ next, and clear the child pointer. Continue walking — nested children are handled when reached.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/*
 * class Node { int val; Node prev; Node next; Node child; }  // provided by LeetCode
 */
class Solution {
    public Node flatten(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.child == null) continue;
            Node next = cur.next, child = cur.child;
            cur.next = child;
            child.prev = cur;
            cur.child = null;
            Node tail = child;
            while (tail.next != null) tail = tail.next;   // end of the child list
            tail.next = next;
            if (next != null) next.prev = tail;
        }
        return head;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting the prev pointers or leaving child non-null — the judge checks both.

---

⬅️ [Previous: LRU Cache](./015-lru-cache.md) · [📋 Linked List list](./README.md) · [Next: Merge k Sorted Lists](./017-merge-k-sorted-lists.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
