# Lesson 11: your first LLM API call, then the same call streamed word by word.
# Needs the setup from lesson 10: pip install anthropic python-dotenv, and ANTHROPIC_API_KEY in .env
from dotenv import load_dotenv
import anthropic

load_dotenv()
client = anthropic.Anthropic()                  # reads ANTHROPIC_API_KEY from the environment
MODEL = "claude-haiku-5-5"                      # a small, fast model

reply = client.messages.create(
    model=MODEL,
    max_tokens=200,                             # upper limit on the answer's length
    temperature=0.3,                            # low = focused, high = creative
    system="You are a friendly Java tutor. Answer in two short sentences.",
    messages=[{"role": "user", "content": "What is a HashMap?"}],
)
print(reply.content[0].text)
print("tokens in/out:", reply.usage.input_tokens, reply.usage.output_tokens)

print("\nStreaming:")
with client.messages.stream(
    model=MODEL,
    max_tokens=200,
    messages=[{"role": "user", "content": "Explain recursion in one line."}],
) as stream:
    for text in stream.text_stream:              # pieces arrive as they're generated
        print(text, end="", flush=True)
print()
