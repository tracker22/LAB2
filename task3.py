def diff(a, b):
    return a - b if a > b else b - a

def prod(n):
    res = 1
    while n > 0:
        res *= n % 10
        n = n // 10
    return res

def sum_digits(n):
    res = 0
    while n > 0:
        res += n % 10
        n = n // 10
    return res

num = int(input("Enter the number: "))
if num > 0:
    summary = sum_digits(num)
    product = prod(num)
    print(f"{summary} {product} {diff(summary, product)}")
else:
    print("Number is not natural")