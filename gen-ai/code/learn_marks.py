from sklearn.linear_model import LinearRegression

hours = [[1], [2], [3], [4]]
marks = [20, 40, 60, 80]

model = LinearRegression()
model.fit(hours, marks)            # it learns here

print(model.predict([[5]]))        # [100.]
