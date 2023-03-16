list = [0 for i in range(26)]
res = 0

for ch in input():
    list[ord(ch) - ord('a')] += 1
for ch in input():
    list[ord(ch) - ord('a')] -= 1

print(sum(map(abs, list)))

