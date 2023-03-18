N, M = map(int, input().split())
castle = [[0] * M for _ in range(N)]
row = 0
col = 0

for i in range(N):
    line = input()
    flag = False
    for j in range(M):
        castle[i][j] = line[j]
        if line[j] == 'X':
            flag = True
    if flag == False:
        col += 1

for i in range(M):
    if 'X' not in [castle[j][i] for j in range(N)]:
        row += 1

print(max(row, col))
