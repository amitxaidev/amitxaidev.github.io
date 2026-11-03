import numpy as np

emb = {"cat": np.array([0.9, 0.8]),
       "dog": np.array([0.8, 0.9]),
       "car": np.array([0.1, -0.9])}

def similarity(a, b):
    a, b = emb[a], emb[b]
    return a @ b / (np.linalg.norm(a) * np.linalg.norm(b))

print(round(similarity("cat", "dog"), 2))  # 0.99
print(round(similarity("cat", "car"), 2))  # -0.58
