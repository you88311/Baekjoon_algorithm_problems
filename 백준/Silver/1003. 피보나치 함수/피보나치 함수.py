import sys

class Fibo:
    def __init__(self):
        self.tmp1_zero_one_cnt=[]
        self.tmp2_zero_one_cnt=[]
        self.fibo_save=[0 for i in range(41)]
        self.fibo_save[0]=1
        self.fibo_save[1]=1
        self.zero_one_cnt=[[0 for col in range(2)] for row in range(41)]
        self.zero_one_cnt[0][0]=1
        self.zero_one_cnt[0][1]=0
        self.zero_one_cnt[1][0]=0
        self.zero_one_cnt[1][1]=1

    def Cnt_zero_one(self,n):
        if self.fibo_save[n]==1: #이미 계산한 경우
            return [self.zero_one_cnt[n][0], self.zero_one_cnt[n][1]]
        else:                    #아직 계산 안한 경우
            self.tmp1_zero_one_cnt=self.Cnt_zero_one(n-1)
            self.tmp2_zero_one_cnt=self.Cnt_zero_one(n-2)
            self.zero_one_cnt[n][0]=self.tmp1_zero_one_cnt[0]+self.tmp2_zero_one_cnt[0]
            self.zero_one_cnt[n][1]=self.tmp1_zero_one_cnt[1]+self.tmp2_zero_one_cnt[1]
            self.fibo_save[n]=1
            return self.zero_one_cnt[n]
                

    def Cnt_init(self):
        self.tmp1_zero_one_cnt=[0,0]
        self.tmp2_zero_one_cnt=[0,0]

total_input_cnt = int(sys.stdin.readline().rstrip())
fibo = Fibo()

for i in range(total_input_cnt):
    n=int(sys.stdin.readline().rstrip())
    fibo.Cnt_zero_one(n)
    fibo.Cnt_init()
    print(fibo.zero_one_cnt[n][0], fibo.zero_one_cnt[n][1])