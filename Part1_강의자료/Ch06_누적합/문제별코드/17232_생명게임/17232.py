N, M, T = map(int,input().split())
K, A, B = map(int,input().split())

board = [[0] * (M + 1)] + [[0] + list(input().rstrip()) for _ in range(N)]
acc = [[0] * (M + 1) for _ in range(N + 1)]

def set_prefix_sum(N, M):
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1]
            if board[i][j] == '*':
                acc[i][j] += 1

def get_range_sum(N, M, K, row, col, alive):
    left, right, up, down = max(0, col - K - 1), min(M, col + K), max(0, row - K - 1), min(N, row + K)
    return acc[down][right] - acc[down][left] - acc[up][right] + acc[up][left] - alive

for _ in range(T):
    set_prefix_sum(N, M)
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if board[i][j] == '*':
                near_alive = get_range_sum(N, M, K, i, j, 1)
                if near_alive < A or B < near_alive:
                    board[i][j] = '.'
            else:
                near_alive = get_range_sum(N, M, K, i, j, 0)
                if A < near_alive and near_alive <= B:
                    board[i][j] = '*'

print(*[''.join(board[i][1:]) for i in range(1, N + 1)], sep='\n')
