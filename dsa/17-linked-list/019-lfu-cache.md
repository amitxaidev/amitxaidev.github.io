# 19. LFU Cache

**LeetCode 460** · 🔴 Hard · Pattern: **Frequency buckets of LinkedHashSets**
🔗 Solve it here: [https://leetcode.com/problems/lfu-cache/](https://leetcode.com/problems/lfu-cache/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/019-lfu-cache.html](https://amitxaidev.github.io/dsa/17-linked-list/019-lfu-cache.html)

## The problem, in short

Design a cache with get and put in O(1). When full, evict the key used least often; among ties, evict the least recently used one.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track each key's value and use count.

</details>

<details>
<summary>💡 Hint 2</summary>

Group keys by count. Inside a group, keep insertion order (LinkedHashSet) so the oldest is first.

</details>

<details>
<summary>💡 Hint 3</summary>

Keep the current minimum count; it only resets to 1 when a new key is inserted.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Maps: key → value, key → count, count → LinkedHashSet of keys. Touching a key moves it from bucket c to c + 1 (and bumps minCount if bucket c emptied and c was the minimum). Evict the first key in bucket minCount.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class LFUCache {
    private final int capacity;
    private int minCount = 0;
    private final Map<Integer, Integer> vals = new HashMap<>(), counts = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> buckets = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        touch(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            touch(key);
            return;
        }
        if (vals.size() == capacity) {
            int evict = buckets.get(minCount).iterator().next();   // oldest among least used
            buckets.get(minCount).remove(evict);
            vals.remove(evict);
            counts.remove(evict);
        }
        vals.put(key, value);
        counts.put(key, 1);
        buckets.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minCount = 1;
    }

    private void touch(int key) {
        int c = counts.get(key);
        counts.put(key, c + 1);
        buckets.get(c).remove(key);
        if (c == minCount && buckets.get(c).isEmpty()) minCount++;
        buckets.computeIfAbsent(c + 1, k -> new LinkedHashSet<>()).add(key);
    }
}
```

</details>

## Complexity

- **Time:** O(1) average per operation.
- **Space:** O(capacity).

## Common mistake

⚠️ Forgetting that minCount can only increase by touching keys and resets to 1 on every new insert.

---

⬅️ [Previous: Reverse Nodes in k-Group](./018-reverse-nodes-in-k-group.md) · [📋 Linked List list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
