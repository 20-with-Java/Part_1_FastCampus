from collections import Counter

counter = Counter(input().upper())

if len(counter) > 1 and counter.most_common()[0][1] == counter.most_common()[1][1]:
    print('?')
else:
    print(counter.most_common()[0][0])

