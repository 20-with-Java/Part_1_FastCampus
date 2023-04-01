N, M = map(int, input().split())
map = [input() for _ in range(N)]

def count_diff(row, col, pattern):
    cnt = 0
    for i in range(row, row + 8):
        for j in range(col, col + 8):
            if map[i][j] != pattern[(i + j) % 2]:
                cnt += 1
    return cnt

ans = N * M
for i in range(N - 7):
    for j in range(M - 7):
        cnt_BW = count_diff(i, j, "BW")
        cnt_WB = count_diff(i, j, "WB")
        ans = min(ans, min(cnt_BW, cnt_WB))

print(ans)
