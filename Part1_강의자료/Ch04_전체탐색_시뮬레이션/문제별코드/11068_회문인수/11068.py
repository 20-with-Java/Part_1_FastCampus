def is_palindrome(x, base):
    digit = []
    while x > 0:
        digit.append(x % base)
        x //= base

    for i in range(len(digit) // 2):
        if digit[i] != digit[-i - 1]:
            return 0
    return 1

T = int(input())

for _ in range(T):
    X = int(input())
    ans = 0

    for i in range(2, 65):
        ans = is_palindrome(X, i)
        if ans:
            break

    print(ans)
