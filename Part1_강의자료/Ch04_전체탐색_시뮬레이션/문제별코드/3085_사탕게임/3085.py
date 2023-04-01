N = int(input())
board = [list(input()) + [0] for _ in range(N)]
board.append([0] * (N + 1))
res = 1

def calc_col_score(col):
    global res

    if col >= N:
        return
    
    max_score = 1
    tmp = 1
    color = board[0][col]
    for i in range(1, N):
        if board[i][col] != color:
            max_score = max(max_score, tmp)
            tmp = 1
            color = board[i][col]
        else:
            tmp += 1
    res = max(res, max(max_score, tmp))

def calc_row_score(row):
    global res

    if row >= N:
        return

    max_score = 1
    tmp = 1
    color = board[row][0]
    for i in range(1, N):
        if board[row][i] != color:
            max_score = max(max_score, tmp)
            tmp = 1
            color = board[row][i]
        else:
            tmp += 1
    res = max(res, max(max_score, tmp))

def swap_candy(row, col):
    color = board[row][col]

    if color != board[row + 1][col]:
        board[row][col], board[row + 1][col] = board[row + 1][col], board[row][col]
        calc_row_score(row)
        calc_row_score(row + 1)
        calc_col_score(col)
        board[row][col], board[row + 1][col] = board[row + 1][col], board[row][col]
    if color != board[row][col + 1]:
        board[row][col], board[row][col + 1] = board[row][col + 1], board[row][col]
        calc_col_score(col)
        calc_col_score(col + 1)
        calc_row_score(row)
        board[row][col], board[row][col + 1] = board[row][col + 1], board[row][col]

for i in range(N):
    calc_row_score(i)
    calc_col_score(i)

for i in range(N):
    for j in range(N):
        swap_candy(i, j)

print(res)
