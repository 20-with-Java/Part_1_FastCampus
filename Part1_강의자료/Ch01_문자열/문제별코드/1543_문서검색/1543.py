doc = input() # 문서를 입력받음
word = input() # 단어를 입력받음
start_index = 0
count = 0
while True:
  find_index = doc.find(word, start_index) # find() 함수를 사용해서 단어를 찾음
  if find_index < 0:
    break
  start_index = find_index + len(word)
  count += 1
print(count)