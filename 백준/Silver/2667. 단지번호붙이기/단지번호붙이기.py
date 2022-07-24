class Set:
    def __init__(self):
        self.set_num=[]
        self.set_length=0
        self.curr_setcnt=0
    def SetFind(self,m,i,j):
        if i>=0 and j>=0 and i < m.map_size and j<m.map_size:
            if int(m.is_searched[i][j])==0: #아직 검색 안한 공간이고
                m.is_searched[i][j]=1      #탐색 후 탐색표시
                if int(m.map[i][j])==1:           #집이 있다면
                    self.curr_setcnt+=1
                    self.SetFind(m,i,j+1) #상하좌우 탐색
                    self.SetFind(m,i+1,j)
                    self.SetFind(m,i-1,j)
                    self.SetFind(m,i,j-1)
            
        
    def SetFint_init(self):
        if self.curr_setcnt!=0:
            self.set_num.append(self.curr_setcnt)
            self.curr_setcnt=0
             
    def SetLengthPrint(self):
        self.set_length=len(self.set_num)
        print (self.set_length)
    
    def SetNumPrint(self):
        self.set_num=sorted(self.set_num)
        self.set_length=len(self.set_num)
        for i in range(self.set_length):
            print(int(self.set_num[i]))

class Map:
    def __init__(self):
        self.map_size=0
        self.map=[]
        self.is_searched=[]

    def MakeMap(self):
        self.map_size = int(input())
        self.map = [[0 for row in range(self.map_size)]for rows in range(self.map_size)]
        self.is_searched = [[0 for row in range(self.map_size)]for rows in range(self.map_size)]
        
        for i in range(self.map_size):
            temp=input()
            temp=list(temp)
            for j in range(self.map_size):
                self.map[i][j]=temp[j]



map1 = Map()
set = Set()

map1.MakeMap()

for i in range(map1.map_size):
    for j in range(map1.map_size):
        set.SetFind(map1,i,j)
        set.SetFint_init()

set.SetLengthPrint()
set.SetNumPrint()
