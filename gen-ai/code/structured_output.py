# Lesson 8: system prompts and structured (JSON) output, checked before your code trusts it.
import json

# What you send: a system prompt with the rules, and the user's message
messages = [
    {"role": "system", "content": "You extract job candidates. Reply ONLY with JSON: "
                                  '{"name": string, "skills": [string], "years": integer}'},
    {"role": "user", "content": "Asha has 2 years of experience with Java and SQL."},
]

# What a model often sends back: JSON wrapped in a markdown fence
reply = '```json\n{"name": "Asha", "skills": ["Java", "SQL"], "years": 2}\n```'

SCHEMA = {"name": str, "skills": list, "years": int}

def parse(reply: str) -> dict:
    text = reply.strip().removeprefix("```json").removesuffix("```").strip()
    data = json.loads(text)                      # fails loudly if it isn't JSON
    for key, kind in SCHEMA.items():             # check every field and its type
        if not isinstance(data.get(key), kind):
            raise ValueError(f"field '{key}' is missing or not {kind.__name__}")
    return data

candidate = parse(reply)
print(candidate["name"], candidate["skills"], candidate["years"])

for bad in ['Sure! Here is the JSON you asked for.', '{"name": "Ravi", "years": "two"}']:
    try:
        parse(bad)
    except (json.JSONDecodeError, ValueError) as e:
        print("rejected:", type(e).__name__)
