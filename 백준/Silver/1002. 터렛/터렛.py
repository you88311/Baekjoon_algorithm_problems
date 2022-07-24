#두 점과 거리(범위)가 주어졌을 때 
#두 점에서 보내는 직선이 만나는 경우 구하기
 
import sys

def match_point_cnt(x1,y1,r1,x2,y2,r2):
    
    point_distance = ((x1-x2)**2 + (y1-y2)**2)**0.5
    given_distance = r1+r2
    distance_set = [r1,r2,point_distance]
    max_distance = max(distance_set)
    max_dis_index = distance_set.index(max_distance)
    distance_set.pop(max_dis_index)

    if x1==x2 and y1==y2 : #두 점 동일한 경우
        if r1 == r2 : #주어진 거리도 동일할 경우
            if r1==0: #완전 동일한 점
                return 1
            else:     
                return -1
        else:
            return 0
    elif r1+r2 ==point_distance: #외접하는 경우
        return 1
    elif abs(r1-r2) == point_distance: #내접하는 경우
        return 1
    elif max_distance < distance_set[0] + distance_set[1]: #삼각형 성립조건
        if given_distance > point_distance:
            return 2
        else:
            return 0
    else:
        return 0


test_total_cnt =int(input())

test_case = [[0 for i in range(6)] for i in range(test_total_cnt)]
for i in range(test_total_cnt):
    test_case[i] = list(map(int, sys.stdin.readline().rstrip().split(' ')))

match_cnt = [-2 for i in range(test_total_cnt)]


for i in range(test_total_cnt):
    x1,y1,r1,x2,y2,r2 = test_case[i]
    match_cnt[i] = match_point_cnt(x1,y1,r1,x2,y2,r2)
    print(match_cnt[i])