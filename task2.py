def find_unique(v):
    unique = []
    for email in v:
        if email not in unique:
            unique.append(email)
    return unique

def format_email(s):
    result = []
    seen_at = False
    seen_star = False
    
    for char in s:
        if char == '@':
            seen_at = True
        if not seen_at:
            if char == '*':
                seen_star = True
                continue
            if seen_star:
                continue
            if char == '.':
                continue
        result.append(char)
    
    return ''.join(result)

def is_allowed(s):
    not_allowed_chars = {'&', '=', '+', '-', '_', '<', '>', ',', "'"}
    
    if not s or s[0] == '.':
        return False
    if '@' not in s:
        return False
    
    at_index = s.index('@')
    if at_index < 6 or at_index > 30:
        return False
    
    for char in s[:at_index]:
        if char in not_allowed_chars:
            return False
    
    if s.rfind('.') <= at_index or '.' not in s:
        return False
    
    return True

def main():
    emails = [".555555@.", "123456*7890@.mailru", "123456@.mailru", 
              "123456@.mailru", "1234567@.mailru"]
    
    # Фильтрация и форматирование email
    valid_emails = [format_email(email) for email in emails if is_allowed(email)]
    
    if not valid_emails:
        print("No unique emails")
    else:
        print(len(find_unique(valid_emails)))

if __name__ == "__main__":
    main()