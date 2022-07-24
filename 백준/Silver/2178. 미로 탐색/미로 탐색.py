class Maze:
    def __init__(self,N,M):
        self.map = [[0 for i in range(M)] for j in range(N)]
        self.is_searched = [[False for i in range(M)] for j in range(N)]
        self.distance = [[0 for i in range(M)] for j in range(N)]

    def adj(self, i, j):
        adj_node = []
        if can_search(self.is_searched, self.map, i, j+1):
            adj_node.append([i,j+1])
        if can_search(self.is_searched, self.map, i-1, j):
            adj_node.append([i-1,j])
        if can_search(self.is_searched, self.map, i+1, j):
            adj_node.append([i+1,j])
        if can_search(self.is_searched, self.map, i, j-1):
            adj_node.append([i,j-1])

        return adj_node

class Queue:
    def __init__(self):
        self.saved = []

    def insert(self,data):
        self.saved.append(data)

    def delete(self):
        return self.saved.pop(0)

    def is_empty(self):
        if len(self.saved) == 0:
            return True
        else:
            return False

def bfs(maze,queue,N,M):
    queue.insert([0,0])
    maze.is_searched[0][0] = True
    maze.distance[0][0] = 1

    while not queue.is_empty():
        tmp = queue.delete()
        i, j = tmp[0], tmp[1]
        distance = maze.distance[i][j]
        if des_reached(i, j ,N, M):
            break
        for adj in maze.adj(i,j):
            queue.insert(adj)
            a,b = adj[0] , adj[1]
            maze.distance[a][b] = distance+1
            maze.is_searched[a][b] = True

    return maze.distance[N-1][M-1]

def can_search(is_searched,map,i,j):
    if i >= N or j >= M or i<0 or j<0: #미로 범위 초과
        return False
    if is_searched[i][j] == True:
        return False
    if map[i][j] == 0:
        return False
    return True

def des_reached(i, j, N, M):
    if i==N-1 and j==M-1:
        return True

############################################
N , M= map(int,input().rstrip().split())
maze = Maze(N,M)
queue = Queue()

for i in range(N):
    input_ = list(input().rstrip())
    for j in range(M):
        maze.map[i][j] = int(input_[j])

shortest = bfs(maze,queue,N,M)
print(shortest)