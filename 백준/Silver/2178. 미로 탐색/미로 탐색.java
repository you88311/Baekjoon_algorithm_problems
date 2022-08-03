import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //queue선언
        Queue<Integer[]> queue = new LinkedList<>();
        String[] strArray = br.readLine().split(" ");
        int N = Integer.parseInt(strArray[0]);
        int M = Integer.parseInt(strArray[1]);
        int[][] maze = new int[N][M];
        int[][] dist = new int[N][M];
        int[] dX = {1, -1, 0, 0};
        int[] dY = {0, 0, 1, -1};
        Integer[] cord;
        int curDist = 0;
        int adjX = 0;
        int adjY = 0;

        for (int i = 0; i < maze.length; i++) {
            //초기화
            strArray = br.readLine().split("");
            int j = 0;
            for (String e : strArray)
                maze[i][j] = Integer.parseInt(strArray[j++]);
        }

        //dist fill -1
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        //0,0 dist =1 시작
        dist[0][0] = 1;
        queue.add(new Integer[]{0, 0});
        //dfs
        while (!queue.isEmpty()) {
            cord = queue.poll();
            //if (x,y) == (N,M) return dist[N][M]
            if(cord[0] == N-1 && cord[1] == M-1) {
                System.out.println(dist[cord[0]][cord[1]]);
                return;
            }
            for (int k = 0; k < 4; k++) {
                adjX = cord[0] + dX[k];
                adjY = cord[1] + dY[k];
                if (N <= adjX || adjX < 0 || M <= adjY || adjY < 0) continue;
                if (dist[adjX][adjY] == -1 && maze[adjX][adjY] == 1) {
                    queue.add(new Integer[]{adjX, adjY});
                    //queue에 넣는 경우 기존dist값+1을 dist에 저장
                    dist[adjX][adjY] = dist[cord[0]][cord[1]] + 1;
                }
            }
        }
        //if (x,y) == (N,M) return dist[N][M]
        System.out.println( dist[N-1][M-1]);
    }
}

