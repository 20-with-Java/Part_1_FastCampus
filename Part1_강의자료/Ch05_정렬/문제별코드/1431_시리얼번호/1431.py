class Serial:
    def __init__(self, serial: str, sum: int):
        self.serial = serial
        self.sum = sum

N = int(input())
serials = []
for i in range(N):
    serial = input().strip()
    total = sum(int(c) for c in serial if c.isdigit())
    serials.append(Serial(serial, total))

serials.sort(key=lambda s: (len(s.serial), s.sum, s.serial))

for s in serials:
    print(s.serial)
