def is_palindrome(str, l, r):
    while l <= r:
        if str[l] != str[r]:
            return False
        l += 1
        r -= 1
    return True

T = int(input())
for _ in range(T):
    str = input()

    ans = 0
    l, r = 0, len(str) - 1
    while l <= r:
        if str[l] != str[r]:
            if is_palindrome(str, l + 1, r) or is_palindrome(str, l, r - 1):
                ans = 1
            else:
                ans = 2
            break
        l += 1
        r -= 1
        
    print(ans)
