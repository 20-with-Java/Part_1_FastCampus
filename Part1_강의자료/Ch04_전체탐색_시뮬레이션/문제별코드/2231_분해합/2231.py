N = int(input())

def generate(seed):
    num = seed
    while seed > 0:
        num += seed % 10
        seed //= 10
    return num

answer = 0
for i in range(N + 1):
    if generate(i) == N:
        answer = i
        break

print(answer)
