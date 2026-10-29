# 18. Reverse Nodes in k-Group

**LeetCode 25** · 🔴 Hard · Pattern: **Group reversal with reconnection**
🔗 Solve it here: [https://leetcode.com/problems/reverse-nodes-in-k-group/](https://leetcode.com/problems/reverse-nodes-in-k-group/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/018-reverse-nodes-in-k-group.html](https://amitxaidev.github.io/dsa/17-linked-list/018-reverse-nodes-in-k-group.html)

## The problem, in short

Reverse the nodes of a linked list k at a time. A final group with fewer than k nodes stays as is. Only O(1) extra memory.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Before reversing, check that k nodes remain.

</details>

<details>
<summary>💡 Hint 2</summary>

Reverse one group, then connect the previous group's tail to the new group head.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

groupPrev starts at a dummy. Find the k-th node from groupPrev; if missing, stop. Reverse the nodes between, pointing the first node to the node after the group. Then link groupPrev to the new head and move groupPrev to the old first node (now the group's tail).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break;                       // fewer than k left
            ListNode groupNext = kth.next;
            ListNode prev = groupNext, cur = groupPrev.next;
            while (cur != groupNext) {                    // reverse this group
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ListNode oldFirst = groupPrev.next;
            groupPrev.next = kth;                         // kth is the new group head
            groupPrev = oldFirst;                         // old first is now the tail
        }
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Reversing the last short group too.

---

⬅️ [Previous: Merge k Sorted Lists](./017-merge-k-sorted-lists.md) · [📋 Linked List list](./README.md) · [Next: LFU Cache](./019-lfu-cache.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
