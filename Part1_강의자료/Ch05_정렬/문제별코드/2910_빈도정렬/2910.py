class Message:
    def __init__(self, num: int, idx: int):
        self.num = num
        self.idx = idx

class Frequency:
    def __init__(self, num: int, count: int, first_idx: int):
        self.num = num
        self.count = count
        self.first_idx = first_idx
        
N, C = map(int, input().split())
arr = list(map(int, input().split()))
messages = []
frequencies = []

for i in range(N):
    messages.append(Message(arr[i], i))

messages.sort(key=lambda m: (m.num, m.idx))

frequencies.append(Frequency(messages[0].num, 1, messages[0].idx))
for i in range(1, N):
    if messages[i].num != messages[i - 1].num:
        frequencies.append(Frequency(messages[i].num, 0, messages[i].idx))
    frequencies[-1].count += 1

frequencies.sort(key=lambda f: (-f.count, f.first_idx))

for freq in frequencies:
    print((str(freq.num) + ' ') * freq.count, end='')
print()
