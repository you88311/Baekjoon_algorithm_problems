import sys
import random

seq_total_cnt = int(sys.stdin.readline())
seq = list(map(int,sys.stdin.readline().rstrip().split(' ')))
#seq_total_cnt = 10
#seq = []
#for i in range(seq_total_cnt):
#    seq.append(random.randint(-10,10))

#print("입력 받은 수열")
#print(seq)
"""
max = seq[0]
result = seq[0]

for j in range(1,len(seq)):
    result += seq[j]
    if result < 0:
        result = seq[j]
        if result > max:
            max = result
        if j+1 < len(seq):
            result = 0
    else:
        if result > max:
            max = result
print(max)
"""
dp = []
for i in range(len(seq)):
    dp.append(0)

dp[0] = seq[0]
for i in range(1,len(seq)):
    if dp[i-1] < 0:
        dp[i] = seq[i]
    else:
        dp[i] += dp[i-1] + seq[i]

print(max(dp))