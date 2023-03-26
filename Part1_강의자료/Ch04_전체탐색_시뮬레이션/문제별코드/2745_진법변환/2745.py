# N, B = input().split()
# B = int(B)
# print(int(N, B))

N, B = input().split()
B = int(B)

num_dec = 0
for digit in N:
    num_dec *= B
    if '0' <= digit <= '9':
        num_dec += int(digit)
    else:
        num_dec += 10 + ord(digit) - ord('A')

print(num_dec)
