def get_unique_alphabet_count(alphabet_count):
    return sum(1 for count in alphabet_count if count > 0)

N = int(input())
nyang = input()

alphabet_count = [0] * 26
next_idx = 0
max_length = 0

for i in range(len(nyang)):
    while next_idx < len(nyang):
        alphabet_count[ord(nyang[next_idx]) - ord('a')] += 1
        next_idx += 1
        if get_unique_alphabet_count(alphabet_count) > N:
            next_idx -= 1
            alphabet_count[ord(nyang[next_idx]) - ord('a')] -= 1
            break
    
    max_length = max(max_length, next_idx - i)
    alphabet_count[ord(nyang[i]) - ord('a')] -= 1

print(max_length)
