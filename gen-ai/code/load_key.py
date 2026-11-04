# Lesson 10: load your API key from a .env file, never from the code.
#   1. python -m venv .venv            (then: source .venv/bin/activate   or   .venv\Scripts\activate on Windows)
#   2. pip install anthropic python-dotenv
#   3. create a file named .env with one line:   ANTHROPIC_API_KEY=your-key-here
#   4. add .env to .gitignore so it never reaches GitHub
import os
from dotenv import load_dotenv

load_dotenv()                                   # reads .env into the environment
key = os.getenv("ANTHROPIC_API_KEY")

if not key:
    raise SystemExit("No key found. Add ANTHROPIC_API_KEY=... to your .env file.")

print("Key loaded:", key[:7] + "..." + key[-4:])   # never print the whole key
print(".env in .gitignore:", os.path.exists(".gitignore") and ".env" in open(".gitignore").read())
