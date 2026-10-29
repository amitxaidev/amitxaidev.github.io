# 18. Accounts Merge

**LeetCode 721** · 🟡 Medium · Pattern: **Union-Find on emails**
🔗 Solve it here: [https://leetcode.com/problems/accounts-merge/](https://leetcode.com/problems/accounts-merge/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/018-accounts-merge.html](https://amitxaidev.github.io/dsa/23-graphs/018-accounts-merge.html)

## The problem, in short

Each account is a name followed by emails. Two accounts belong to the same person if they share any email. Merge them and return each person's name with their sorted emails.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Union all emails within one account.

</details>

<details>
<summary>💡 Hint 2</summary>

Map each email to an id and remember one owner name per email.

</details>

<details>
<summary>💡 Hint 3</summary>

Group emails by their root, then sort each group.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Give each new email an index; union every email of an account with the account's first email. Then collect emails per root in a map, sort them, and prepend the name.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> id = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        for (List<String> acc : accounts)
            for (int i = 1; i < acc.size(); i++) {
                id.putIfAbsent(acc.get(i), id.size());
                owner.put(acc.get(i), acc.get(0));
            }
        parent = new int[id.size()];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (List<String> acc : accounts) {
            int first = id.get(acc.get(1));
            for (int i = 2; i < acc.size(); i++) parent[find(id.get(acc.get(i)))] = find(first);   // same person
        }
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : id.keySet()) groups.computeIfAbsent(find(id.get(email)), k -> new ArrayList<>()).add(email);
        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            emails.add(0, owner.get(emails.get(0)));
            res.add(emails);
        }
        return res;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
```

</details>

## Complexity

- **Time:** O(N log N), N = total emails (sorting dominates).
- **Space:** O(N).

## Common mistake

⚠️ Merging accounts by name — different people can share a name.

---

⬅️ [Previous: Redundant Connection](./017-redundant-connection.md) · [📋 Graphs list](./README.md) · [Next: Word Ladder](./019-word-ladder.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
