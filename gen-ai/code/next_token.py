import numpy as np

words = ["mat", "floor", "sofa", "moon"]
scores = np.array([3.0, 2.1, 1.2, 0.5])

probs = np.exp(scores) / np.exp(scores).sum()
for w, p in zip(words, probs):
    print(w, round(p, 2))

# mat 0.6  floor 0.25  sofa 0.1  moon 0.05
