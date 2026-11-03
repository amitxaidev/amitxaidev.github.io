def cost(inp, out, in_price=100, out_price=400):
    # rupees per million tokens, example prices only
    return inp / 1e6 * in_price + out / 1e6 * out_price

print(cost(2_000, 500))           # 0.4
print(cost(2_000, 500) * 10_000)  # 4000.0
