N = int(input())

distance = [int(input()) for _ in range(N)]
distance_sum = sum(distance)

pair_index = 1
left_distance = distance[0]
right_distance = distance_sum - distance[0]
max_distance = min(left_distance, right_distance)

for i in range(N):
    while left_distance < right_distance:
        left_distance += distance[pair_index]
        right_distance -= distance[pair_index]
        pair_index = (pair_index + 1) % N
    max_distance = max(max_distance, min(left_distance, right_distance))
    left_distance -= distance[i]
    right_distance += distance[i]

print(max_distance)
