def make_seq(seq, num_set, stack):
    i = 0
    result = []
    while i <= len(seq)-1:
        key = seq[i]
        if is_at_top(stack, key):
            stack.pop()
            result.append('-')
        elif is_in_numset(num_set,key):
            j = find_index(num_set,key)
            set_size = len(num_set)
            for k in range(set_size - j):
                tmp = num_set.pop()
                stack.append(tmp)
                result.append('+')
            tmp = stack.pop()
            result.append('-')
        else:
            return False

        i +=1

    return result


def is_at_top(stack, key):
    if len(stack) == 0 or stack[len(stack)-1] != key:
        return False
    return True

def is_in_numset(num_set,key):
    if len(num_set) ==0 or num_set[len(num_set) - 1] > key:
        return False
    return True

def find_index(num_set, key):
    return num_set[0] - key

n = int(input())
seq = []
for i in range(n):
    seq.append(int(input()))

num_set = []
for i in range(n,0,-1):
    num_set.append(i)
stack = []

result = make_seq(seq, num_set, stack)
if result == False:
    print("NO")
else:
    for i in range(len(result)):
        print(result[i])