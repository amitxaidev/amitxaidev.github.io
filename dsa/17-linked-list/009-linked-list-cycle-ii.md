# 9. Linked List Cycle II

**LeetCode 142** · 🟡 Medium · Pattern: **Floyd's cycle entrance**

## The problem, in short

Return the node where a linked list's cycle begins, or null if there is no cycle.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/linked-list-cycle-ii/](https://leetcode.com/problems/linked-list-cycle-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/009-linked-list-cycle-ii.html](https://amitxaidev.github.io/dsa/17-linked-list/009-linked-list-cycle-ii.html)

## Understanding

**Really asking:** where does the cycle start?

**Why this works:** after slow and fast meet, the distance from head to the entrance equals the distance from the meeting point to the entrance. Walk both at speed 1.

**Example:** 3 → 2 → 0 → -4 → (2)
```text
meet at -4
one pointer from 3, one from -4: next steps land on 2 together → entrance 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

First detect the meeting point with slow and fast pointers.

</details>

<details>
<summary>💡 Hint 2</summary>

Distance from head to the cycle start equals distance from the meeting point to the cycle start (going forward).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

After slow and fast meet, start a pointer at head and move it and slow one step at a time; they meet at the cycle entrance.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {      // walk both to the entrance
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Returning the meeting point itself — it's somewhere inside the cycle, not necessarily the start.

---

⬅️ [Previous: Remove Nth Node From End of List](./008-remove-nth-node-from-end-of-list.md) · [📋 Linked List list](./README.md) · [Next: Add Two Numbers](./010-add-two-numbers.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
