current = input().split(":")
target = input().split(":")
current_h, current_m, current_s = map(int, current)
target_h, target_m, target_s = map(int, target)

current_sec = current_h * 3600 + current_m * 60 + current_s
target_sec = target_h * 3600 + target_m * 60 + target_s

need_sec = target_sec - current_sec
if need_sec <= 0:
    need_sec += 24 * 3600

need_h = need_sec // 3600
need_m = (need_sec % 3600) // 60
need_s = need_sec % 60

print("{:02d}:{:02d}:{:02d}".format(need_h, need_m, need_s))
