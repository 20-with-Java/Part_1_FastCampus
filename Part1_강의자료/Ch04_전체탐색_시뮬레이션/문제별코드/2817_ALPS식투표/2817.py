X = int(input())
N = int(input())

name = [-1] * 26
lst = []

for i in range(N):
    staff, vote = tuple(input().split())
    vote = int(vote)
    if vote * 20 >= X:
        name[ord(staff) - ord('A')] = 0
        for j in range(1, 15):
            lst.append((vote / j, staff))

lst.sort(key=lambda x:x[0], reverse=True)

for i in range(14):
    name[ord(lst[i][1]) - ord('A')] += 1

for i in range(26):
    if name[i] != -1:
        print(chr(i + ord('A')), name[i])
