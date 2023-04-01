from itertools import combinations

dwarf = []

for i in range(9):
    dwarf.append(int(input()))

for com in combinations(dwarf, 7):
    if (sum(com) == 100):
        for i in sorted(com):
            print(i)
        break

