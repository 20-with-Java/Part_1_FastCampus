# print(input().swapcase())

s = input()
ans = ""
for c in s:
    ans += c.lower() if c.isupper() else c.upper()

print(ans)
