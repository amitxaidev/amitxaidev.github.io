import random

text = ("the cat sat on the mat "
        "the cat ran to the mat")
words = text.split()

# Training: write down which word came after which
next_words = {}
for a, b in zip(words, words[1:]):
    next_words.setdefault(a, []).append(b)

# Generating: keep picking a word that followed the last one
random.seed(7)
word = "the"
output = [word]

for _ in range(5):
    word = random.choice(next_words[word])
    output.append(word)

print(" ".join(output))  # the cat sat on the cat
