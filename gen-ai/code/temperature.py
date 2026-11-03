import numpy as np

scores = np.array([3.0, 2.0, 1.0])
for t in [0.2, 1.0, 2.0]:
    p = np.exp(scores / t)
    print(t, (p / p.sum()).round(2))

# 0.2 [0.99 0.01 0.  ]
# 1.0 [0.67 0.24 0.09]
# 2.0 [0.51 0.31 0.19]
