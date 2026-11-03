vocab = {"i": 0, "love": 1, "java": 2, "python": 3}

def tokenize(text):
    words = text.lower().split()
    return [vocab.get(w, -1) for w in words]

print(tokenize("I love Python"))  # [0, 1, 3]
print(tokenize("I love Rust"))    # [0, 1, -1]
