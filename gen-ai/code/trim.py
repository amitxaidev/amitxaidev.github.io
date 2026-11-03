def trim(history, limit):
    kept, used = [], 0
    for msg in reversed(history):
        cost = len(msg.split())   # rough count
        if used + cost > limit:
            break
        kept.append(msg)
        used += cost
    return list(reversed(kept))

chat = ["hi there", "tell me about java",
        "and what about python then"]
print(trim(chat, 9))
