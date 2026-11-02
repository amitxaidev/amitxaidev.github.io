def is_spam(email):
    email = email.lower()
    if "free money" in email:
        return True
    return False

print(is_spam("FREE MONEY now!"))  # True
print(is_spam("Fr33 m0ney now!"))  # False
