# doc=input()
# word=input()
# print(doc.count(word))

doc = input()
word = input()

start_index = 0
count = 0
while True:
    find_index = doc.find(word, start_index)
    if find_index < 0:
        break
    start_index = find_index + len(word)
    count += 1

print(count)
