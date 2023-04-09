import sys
input = sys.stdin.readline

N = int(input())
logs = set()

for _ in range(N):
    name, log = input().split()
    if name in logs:
        logs.remove(name)
    else:
        logs.add(name)

for name in sorted(logs, reverse=True):
    print(name)
