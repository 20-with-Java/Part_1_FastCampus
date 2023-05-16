def get_unique_alphabet_count(alphabet_count):
    unique_alphabet_count = 0
    for count in alphabet_count:
        if count > 0:
            unique_alphabet_count += 1
    return unique_alphabet_count

N = int(input())
nyang = input()

alphabet_count = [0] * 26
next = 0
max_length = 0

for i in range(len(nyang)):
    while next < len(nyang):
        alphabet_count[ord(nyang[next]) - ord('a')] += 1
        next += 1
        if get_unique_alphabet_count(alphabet_count) > N:
            next -= 1
            alphabet_count[ord(nyang[next]) - ord('a')] -= 1
            break
    
    max_length = max(max_length, next - i)
    alphabet_count[ord(nyang[i]) - ord('a')] -= 1

print(max_length)
