N = int(input())
titles = []

for i in range(N):
    title = input().strip()
    titles.append(title)

titles.sort()

max_title = titles[0]
max_cnt = 1
cur_cnt = 1
for i in range(1, N):
    if titles[i - 1] != titles[i]:
        cur_cnt = 0
    cur_cnt += 1
    if max_cnt < cur_cnt or (max_cnt == cur_cnt and titles[i] < max_title):
        max_cnt, max_title = cur_cnt, titles[i]

print(max_title)
