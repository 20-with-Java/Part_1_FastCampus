triangle_nums = []
is_eureka = [0] * 1001

for i in range(1, 1001):
    num = i * (i + 1) // 2
    if num > 1000:
        break
    triangle_nums.append(num)

for i in range(len(triangle_nums)):
    for j in range(i, len(triangle_nums)):
        for k in range(j, len(triangle_nums)):
            num = triangle_nums[i] + triangle_nums[j] + triangle_nums[k]
            if num > 1000:
                break
            is_eureka[num] = 1

T = int(input())
for _ in range(T):
    K = int(input())
    print(is_eureka[K])
