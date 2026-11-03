def build_prompt(role, task, context, example, fmt):
    return (f"Role: {role}\n"
            f"Task: {task}\n"
            f"Context: {context}\n"
            f"Example: {example}\n"
            f"Format: {fmt}")

print(build_prompt(
    "senior Java interviewer",
    "ask me 3 HashMap questions",
    "I am a fresher, interview next week",
    "Q: What is a hash collision?", "numbered list"))
