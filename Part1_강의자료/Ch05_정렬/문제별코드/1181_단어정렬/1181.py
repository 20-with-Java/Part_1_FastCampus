import sys
input = sys.stdin.readline

N = int(input())
lst = list([input().rstrip() for _ in range(N)])

lst.sort(key=lambda x: (len(x), x))

print(lst[0])
for i in range(1, N):
    if lst[i - 1] != lst[i]:
        print(lst[i])
