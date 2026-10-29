# 13. Reverse Linked List II

**LeetCode 92** · 🟡 Medium · Pattern: **Reverse a sublist in place**
🔗 Solve it here: [https://leetcode.com/problems/reverse-linked-list-ii/](https://leetcode.com/problems/reverse-linked-list-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/013-reverse-linked-list-ii.html](https://amitxaidev.github.io/dsa/17-linked-list/013-reverse-linked-list-ii.html)

## The problem, in short

Reverse only the nodes from position left to position right (1-indexed) in one pass.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Walk to the node just before position left (use a dummy for left = 1).

</details>

<details>
<summary>💡 Hint 2</summary>

Then repeatedly take the node after the current one and move it to the front of the sublist.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

pre = node before the sublist; cur = first node of it. Repeat (right − left) times: move cur.next to right after pre. This "head insertion" reverses the segment in place.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) pre = pre.next;
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode move = cur.next;   // node to bring to the front
            cur.next = move.next;
            move.next = pre.next;
            pre.next = move;
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

⚠️ Losing the connection to the part after right by not linking cur.next correctly during each move.

---

⬅️ [Previous: Reorder List](./012-reorder-list.md) · [📋 Linked List list](./README.md) · [Next: Copy List with Random Pointer](./014-copy-list-with-random-pointer.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
