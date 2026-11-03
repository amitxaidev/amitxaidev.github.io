def pick_model(private=False, image=False, hard=False):
    if private:
        return "open-weight model on your server"
    if image:
        return "multimodal model"
    if hard:
        return "reasoning model"
    return "small fast model"

print(pick_model())               # small fast model
print(pick_model(hard=True))      # reasoning model
print(pick_model(private=True))   # open-weight...
print(pick_model(image=True))
