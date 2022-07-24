step_height = int(input())

dp = [[0 for i in range(10)] for i in range(step_height)]

for i in range(1,10):
    dp[0][i] = 1

for i in range(1, step_height):
    for j in range(10):
        if j == 0:
            dp[i][0] += dp[i-1][1]
        elif j == 9:
            dp[i][9] += dp[i-1][8]
        else:
            dp[i][j] += dp[i-1][j-1] +dp[i-1][j+1] 

total = 0
for i in range(10):
    total += dp[step_height-1][i]

print(total % 1000000000)