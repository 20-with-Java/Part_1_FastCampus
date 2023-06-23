N, B, W = map(int, input().split())
color = input()

white_count = black_count = ans = next_index = 0
for i in range(N):
    while next_index < N:
        if black_count == B and color[next_index] == 'B':
            break
        if color[next_index] == 'W':
            white_count += 1
        else:
            black_count += 1
        next_index += 1
    if white_count >= W:
        ans = max(ans, next_index - i)
    if color[i] == 'W':
        white_count -= 1
    else:
        black_count -= 1
        
print(ans)
