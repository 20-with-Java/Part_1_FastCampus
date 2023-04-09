N = int(input())
titles = {}

for i in range(N):
    title = input().strip()
    if title not in titles:
        titles[title] = 1
    else:
        titles[title] += 1

max_title = None
max_cnt = 0

for title, cnt in titles.items():
    if cnt > max_cnt or (cnt == max_cnt and title < max_title):
        max_title = title
        max_cnt = cnt

print(max_title)
