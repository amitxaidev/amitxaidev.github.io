# 10. Insert Delete GetRandom O(1)

**LeetCode 380** · 🟡 Medium · Pattern: **ArrayList + HashMap**
🔗 Solve it here: [https://leetcode.com/problems/insert-delete-getrandom-o1/](https://leetcode.com/problems/insert-delete-getrandom-o1/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/010-insert-delete-getrandom-o1.html](https://amitxaidev.github.io/dsa/02-java-basics/010-insert-delete-getrandom-o1.html)

## The problem, in short

Design a set that supports insert, remove and getRandom (each element equally likely), all in average O(1) time.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

An ArrayList gives O(1) random access, a HashMap gives O(1) lookup. Use both.

</details>

<details>
<summary>💡 Hint 2</summary>

Removing from the middle of an ArrayList is O(n). Can you remove from the end instead?

</details>

<details>
<summary>💡 Hint 3</summary>

Swap the element to delete with the last element, update its index in the map, then remove the last.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Store values in an ArrayList and a HashMap from value to its index in the list. Insert appends. Remove moves the last element into the removed slot, fixes its map entry, and deletes the tail. getRandom picks a random index.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class RandomizedSet {
    private final List<Integer> list = new ArrayList<>();
    private final Map<Integer, Integer> pos = new HashMap<>();   // value -> index in list
    private final Random rand = new Random();

    public boolean insert(int val) {
        if (pos.containsKey(val)) return false;
        pos.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer i = pos.get(val);
        if (i == null) return false;
        int last = list.get(list.size() - 1);
        list.set(i, last);          // move last element into the hole
        pos.put(last, i);
        list.remove(list.size() - 1);
        pos.remove(val);            // done after put, so it also works when val == last
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
```

</details>

## Complexity

- **Time:** O(1) average for every operation.
- **Space:** O(n).

## Common mistake

⚠️ Forgetting to update the moved element's index in the map, or removing the map entry before the swap when the removed value is itself the last element.

---

⬅️ [Previous: Count Items Matching a Rule](./009-count-items-matching-a-rule.md) · [📋 Java Basics for DSA list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
