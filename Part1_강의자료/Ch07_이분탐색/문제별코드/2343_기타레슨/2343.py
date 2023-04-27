N, M = map(int, input().split())
lectures = list(map(int, input().split()))

l, r = max(lectures), sum(lectures)
while l < r:
    m = (l + r) // 2
    lecture_num, current_length = 1, 0
    for lecture in lectures:
        current_length += lecture
        if current_length > m:
            lecture_num += 1
            current_length = lecture
    if lecture_num > M:
        l = m + 1
    else:
        r = m
print(l)
