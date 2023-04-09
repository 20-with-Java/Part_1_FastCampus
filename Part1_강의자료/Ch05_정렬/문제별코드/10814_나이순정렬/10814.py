class Member:
    def __init__(self, age: int, name: str, idx: int):
        self.age = age
        self.name = name
        self.idx = idx

N = int(input())
members = []
for i in range(N):
    age, name = input().split()
    members.append(Member(int(age), name, i))

members.sort(key=lambda x: (x.age, x.idx))

for member in members:
    print(member.age, member.name)
