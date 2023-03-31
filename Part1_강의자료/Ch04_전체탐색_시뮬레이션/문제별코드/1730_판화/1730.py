N = int(input())
command = input()
pass_vertical = [[0 for _ in range(N)] for _ in range(N)]
pass_horizontal = [[0 for _ in range(N)] for _ in range(N)]

x, y = 0, 0
for i in command:
    if i == 'U':
        if y > 0:
            pass_horizontal[y][x] = True
            y -= 1
            pass_horizontal[y][x] = True
    elif i == 'D':
        if y < N - 1:
            pass_horizontal[y][x] = True
            y += 1
            pass_horizontal[y][x] = True
    elif i == 'L':
        if x > 0:
            pass_vertical[y][x] = True
            x -= 1
            pass_vertical[y][x] = True
    elif i == 'R':
        if x < N - 1:
            pass_vertical[y][x] = True
            x += 1
            pass_vertical[y][x] = True

for i in range(N):
    for j in range(N):
        if not pass_vertical[i][j] and not pass_horizontal[i][j]:
            print(".", end="")
        elif not pass_vertical[i][j] and pass_horizontal[i][j]:
            print("|", end="")
        elif pass_vertical[i][j] and not pass_horizontal[i][j]:
            print("-", end="")
        else:
            print("+", end="")
    print("")
