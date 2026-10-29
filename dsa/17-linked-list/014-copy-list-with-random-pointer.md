# 14. Copy List with Random Pointer

**LeetCode 138** · 🟡 Medium · Pattern: **Interleave copies**
🔗 Solve it here: [https://leetcode.com/problems/copy-list-with-random-pointer/](https://leetcode.com/problems/copy-list-with-random-pointer/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/014-copy-list-with-random-pointer.html](https://amitxaidev.github.io/dsa/17-linked-list/014-copy-list-with-random-pointer.html)

## The problem, in short

Each node has next and random pointers (random can point anywhere or be null). Return a deep copy of the list.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A HashMap old → new makes it easy: O(n) space.

</details>

<details>
<summary>💡 Hint 2</summary>

For O(1) extra space, insert each copy right after its original.

</details>

<details>
<summary>💡 Hint 3</summary>

Then copy.random = original.random.next, and finally separate the two lists.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Three passes: interleave copies (A → A' → B → B'…), set random pointers of the copies, then unweave to restore the original and extract the copy.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/*
 * class Node { int val; Node next; Node random; Node(int val) { ... } }  // provided by LeetCode
 */
class Solution {
    public Node copyRandomList(Node head) {
        for (Node cur = head; cur != null; cur = cur.next.next) {   // 1) interleave
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {   // 2) random pointers
            if (cur.random != null) cur.next.random = cur.random.next;
        }
        Node dummy = new Node(0), tail = dummy;
        for (Node cur = head; cur != null; cur = cur.next) {        // 3) separate
            tail.next = cur.next;
            tail = tail.next;
            cur.next = cur.next.next;
        }
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1) extra.

## Common mistake

⚠️ Setting copy.random = original.random — that points into the original list, not the copy.

---

⬅️ [Previous: Reverse Linked List II](./013-reverse-linked-list-ii.md) · [📋 Linked List list](./README.md) · [Next: LRU Cache](./015-lru-cache.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
