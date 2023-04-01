MAX_NUMBER = 10000
is_selfnum = [True] * (MAX_NUMBER + 1)

def generate(seed):
    num = seed
    while seed > 0:
        num += seed % 10
        seed //= 10
    return num

for i in range(1, MAX_NUMBER + 1):
    seed = i
    while True:
        num = generate(seed)
        if num > MAX_NUMBER:
            break
        is_selfnum[num] = False
        seed = num

for i in range(1, MAX_NUMBER + 1):
    if is_selfnum[i]:
        print(i)
