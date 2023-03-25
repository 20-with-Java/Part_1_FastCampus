import sys
input = sys.stdin.readline

N = int(input())
lst = [input() for _ in range(N)]
lst = list(set(lst))

lst.sort(key=lambda x: (len(x), x))

for str in lst:
    print(str, end='')
