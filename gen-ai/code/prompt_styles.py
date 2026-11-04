# Lesson 7: zero-shot, few-shot and chain-of-thought prompts, built in Python.
# Runs without an API key: it prints the three prompts so you can paste them into any chatbot.

question = ("A pen and a notebook cost 110 rupees together. "
            "The notebook costs 100 rupees more than the pen. How much is the pen?")

# 1. Zero-shot: just the task, no examples
zero_shot = question

# 2. Few-shot: show examples of the format you want, then the real question
examples = [
    ("2 apples cost 20 rupees. How much is 1 apple?", "10 rupees"),
    ("3 pens cost 45 rupees. How much is 1 pen?", "15 rupees"),
]
few_shot = "\n\n".join(f"Q: {q}\nA: {a}" for q, a in examples) + f"\n\nQ: {question}\nA:"

# 3. Chain of thought: ask the model to reason before answering
chain_of_thought = question + "\nThink step by step, then give the final answer on the last line."

for name, prompt in [("zero-shot", zero_shot), ("few-shot", few_shot), ("chain of thought", chain_of_thought)]:
    print(f"--- {name}: {len(prompt.split())} words ---")
print()
print(chain_of_thought)

# The trap: the quick answer is 10 rupees. It's wrong.
pen = (110 - 100) / 2          # pen + (pen + 100) = 110  →  2·pen = 10
print("\ncorrect answer:", pen, "rupees")
