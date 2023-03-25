N = int(input())
command = input()
board = [[0 for _ in range(N)] for _ in range(N)]

x, y = 0, 0
for i in command:
    if i == 'U':
        if y > 0:
            board[y][x] |= 1
            y -= 1
            board[y][x] |= 1
    elif i == 'D':
        if y < N - 1:
            board[y][x] |= 1
            y += 1
            board[y][x] |= 1
    elif i == 'L':
        if x > 0:
            board[y][x] |= 2
            x -= 1
            board[y][x] |= 2
    elif i == 'R':
        if x < N - 1:
            board[y][x] |= 2
            x += 1
            board[y][x] |= 2

for i in range(N):
    for j in range(N):
        if board[i][j] == 0:
            print(".", end="")
        elif board[i][j] == 1:
            print("|", end="")
        elif board[i][j] == 2:
            print("-", end="")
        elif board[i][j] == 3:
            print("+", end="")
    print("")
