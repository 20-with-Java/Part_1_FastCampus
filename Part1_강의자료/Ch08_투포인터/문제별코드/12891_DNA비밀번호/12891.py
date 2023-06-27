S, P = map(int, input().split())
sequence = input()
minimum_base_count = list(map(int, input().split()))
dic = {'A': 0, 'C': 1, 'G': 2, 'T': 3}

current_base_count = [0] * 4
for ch in sequence[:P]:
    current_base_count[dic[ch]] += 1
    
def is_valid_sequence():
    for i in range(4):
        if current_base_count[i] < minimum_base_count[i]:
            return 0
    return 1

ans = is_valid_sequence()
for i in range(1, S - P + 1):
    current_base_count[dic[sequence[i - 1]]] -= 1
    current_base_count[dic[sequence[i + P - 1]]] += 1
    ans += is_valid_sequence()

print(ans)
