def nulls(s, i):
    while i < len(s) and s[i] == '0':
        if i + 1 < len(s) and s[i+1] == '1':
            return i + 1
        elif i + 1 < len(s) and s[i+1] != '0':
            return 0
        i += 1
    return 0

def findPattern(s):
    res = []
    i = 0
    while i < len(s):
        if s[i] == '1':
            if i + 1 < len(s) and s[i+1] == '0':
                last = nulls(s, i+1)
                if last:
                    res.append(s[i:last+1])
                    i = last
            elif i + 1 < len(s) and s[i+1] == '1':
                last = nulls(s, i+2)
                if last:
                    res.append(s[i:last+1])
                    i = last
        i += 1
    return res

s = "1101gdyY101tf11flb10001"
v = findPattern(s)
if not v:
    print("Not found")
else:
    print(' '.join(v))