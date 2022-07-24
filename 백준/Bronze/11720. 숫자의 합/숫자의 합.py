import sys

input_cnt = int(input())
input_line = sys.stdin.readline().rsplit()
input_line = list(input_line[0])
total=0

for i in range(input_cnt):
  total+=int(input_line[i])

print(total)