import queue


class Node:
    def __init__(self, node_num=-1):
        self.adj = []
        self.node_num = node_num
        self.is_searched = False
        self.predecessor = -1

    def adj_add(self, adj_node):
        if not adj_node in self.adj:
            self.adj.append(adj_node)
            self.adj.sort() #정점 번호 작은 것부터 검색하기 위해


class Graph():
    def __init__(self,node_cnt):
        self.graph = [Node() for i in range(node_cnt)]
        self.saved_node = []

    def append(self, node_num):
        if self.graph[node_num-1].node_num == -1: #이미 저장했는지 확인
            self.graph[node_num-1].node_num = node_num
            self.saved_node.append(node_num)


def dfs(graph1, start_node_num):
    stack = []
    stack.append(start_node_num)
    dfs_visit(graph1, start_node_num, stack)


def dfs_visit(graph1, node_num, stack):
    print(node_num, end=' ') #dfs 검색 순서 출력
    graph1.graph[node_num-1].is_searched = True

    for adj_node_num in graph1.graph[node_num-1].adj:
        if graph1.graph[adj_node_num-1].is_searched == False:
            stack.append(adj_node_num)
            dfs_visit(graph1,adj_node_num,stack)


def bfs(graph1,node_num):
    que = queue.Queue()
    que.put(node_num)

    while not que.empty():
        node_num=que.get()
        print(node_num, end=' ') #bfs 검색 결과 출력
        graph1.graph[node_num-1].is_searched = True
        for adj_node_num in graph1.graph[node_num-1].adj:
            if adj_node_num in que.queue:
                continue
            if graph1.graph[adj_node_num-1].is_searched ==False:
                que.put(adj_node_num)


input_ = list(map(int, input().rsplit()))
node_cnt, edge_cnt, start_node = input_[0], input_[1], input_[2]
graph1 = Graph(node_cnt)

for i in range(edge_cnt):
    input_ = list(map(int, input().rsplit()))
    node_num1, node_num2 = input_[0], input_[1]

    if node_num1 not in graph1.saved_node:
        graph1.append(node_num1)

    if node_num2 not in graph1.saved_node:
        graph1.append(node_num2)

    graph1.graph[node_num1-1].adj_add(node_num2)
    graph1.graph[node_num2-1].adj_add(node_num1)


dfs(graph1, start_node)
for i in range(len(graph1.graph)):
    graph1.graph[i].is_searched = False
print()
bfs(graph1, start_node)
