# 5. Sort List

**LeetCode 148** · 🟡 Medium · Pattern: **Merge sort on a linked list**

## The problem, in short

Sort a singly linked list in O(n log n) time.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sort-list/](https://leetcode.com/problems/sort-list/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/005-sort-list.html](https://amitxaidev.github.io/dsa/14-sorting/005-sort-list.html)

## Understanding

**Really asking:** sort a linked list in O(n log n).

**Why this works:** merge sort only needs to walk forward: find the middle, cut, sort both halves, merge.

**Example:** 4 → 2 → 1 → 3
```text
halves 4→2 and 1→3 → sorted 2→4 and 1→3
merge → 1→2→3→4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Merge sort fits linked lists well: no random access needed.

</details>

<details>
<summary>💡 Hint 2</summary>

Find the middle with slow/fast pointers and cut the list in two.

</details>

<details>
<summary>💡 Hint 3</summary>

Merge the two sorted halves like "Merge Two Sorted Lists".

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Split at the middle (stop fast one step early so the left half is not empty-looped), sort both halves recursively, and merge with a dummy head.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * Definition for singly-linked list (provided by LeetCode):
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;   // cut into two halves
        return merge(sortList(head), sortList(right));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(log n) recursion stack.

## Common mistake

⚠️ Not cutting the list (setting mid.next = null), which makes the recursion never shrink.

---

⬅️ [Previous: Sort an Array](./004-sort-an-array.md) · [📋 Sorting list](./README.md) · [Next: Largest Number](./006-largest-number.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
