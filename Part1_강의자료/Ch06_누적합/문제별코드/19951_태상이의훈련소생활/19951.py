import sys
input = sys.stdin.readline

N, M = map(int, input().split())
li = [[0] * (N + 1)] + list(map(int, input().split()))
acc = [0] * (N + 2)

for _ in range(M):
    a, b, k = map(int, input().split())
    acc[a] += k
    acc[b + 1] -= k

sum = 0
for i in range(1, N + 1):
    sum += acc[i]
    print(li[i] + sum, end=' ')
