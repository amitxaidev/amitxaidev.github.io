# 3. Linked List Cycle

**LeetCode 141** · 🟢 Easy · Pattern: **Floyd's cycle detection**
🔗 Solve it here: [https://leetcode.com/problems/linked-list-cycle/](https://leetcode.com/problems/linked-list-cycle/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/003-linked-list-cycle.html](https://amitxaidev.github.io/dsa/17-linked-list/003-linked-list-cycle.html)

## The problem, in short

Decide whether a linked list has a cycle (some node's next points back to an earlier node).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A HashSet of visited nodes works but uses O(n) space.

</details>

<details>
<summary>💡 Hint 2</summary>

Two runners on a circular track: the faster one eventually laps the slower one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Move slow one step and fast two steps. If they ever meet, there's a cycle; if fast reaches null, there isn't.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;   // compare after moving
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Checking slow == fast before moving them — they start equal, so you'd always say "cycle".

---

⬅️ [Previous: Middle of the Linked List](./002-middle-of-the-linked-list.md) · [📋 Linked List list](./README.md) · [Next: Merge Two Sorted Lists](./004-merge-two-sorted-lists.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
