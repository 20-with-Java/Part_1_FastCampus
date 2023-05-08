import sys
input = sys.stdin.readline

N, M = map(int, input().split())
acc = [[0] * (N + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]

for x in range(1, N + 1):
    for y in range(1, N + 1):
        acc[x][y] += acc[x][y - 1] + acc[x - 1][y] - acc[x - 1][y - 1]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1])
