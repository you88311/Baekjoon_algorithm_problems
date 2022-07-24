import sys

def cut(trees,cut_height):
    total = 0
    for i in range(len(trees)):
        cut = trees[i]-cut_height
        if  cut > 0:
            total += cut
    return total

N, M = map(int,input().rstrip().split())
input_ = list(map(int,sys.stdin.readline().rstrip().split()))
trees = []
for i in range(N):
    trees.append(input_[i])
trees.sort()

left = 0
right = trees[N-1]
mid = int((left+right)/2)
cut_len = cut(trees, mid)
result = 0

while left <= right:
    if cut_len > M:
        if result < mid:
            result = mid
        left = mid+1
    elif cut_len < M:
        right = mid-1
    else:
        result = mid
        break
    mid = int((left+right) / 2)
    cut_len = cut(trees, mid)

print(result)
