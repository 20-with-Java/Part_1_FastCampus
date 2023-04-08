import sys
input = sys.stdin.readline

N = int(input())
lst = list(set([input() for _ in range(N)]))

lst.sort(key=lambda x: (len(x), x))

print(''.join(lst))
