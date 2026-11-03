import numpy as np

q = np.array([3.0, 0.0])            # query for "it"
K = np.array([[0.9, 0.1],           # animal
              [0.1, 0.9],           # street
              [0.2, 0.2]])          # tired
V = np.array([[1, 0], [0, 1], [0.5, 0.5]])

scores = K @ q / np.sqrt(2)
w = np.exp(scores) / np.exp(scores).sum()
print(w.round(2))          # [0.71 0.13 0.16]
print((w @ V).round(2))    # [0.79 0.21]
