def is_palindrome(s):
    return s == s[::-1]

T = int(input())
for _ in range(T):
    s = input()

    ans = 0
    l, r = 0, len(s) - 1
    while l <= r:
        if s[l] != s[r]:
            if is_palindrome(s[l + 1:r + 1]) or is_palindrome(s[l:r]):
                ans = 1
            else:
                ans = 2
            break
        l += 1
        r -= 1
        
    print(ans)
