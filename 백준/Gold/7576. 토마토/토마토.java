import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //queue선언
        Queue<Integer[]> queue = new LinkedList<>();
        String[] strArray = br.readLine().split(" ");
        int M = Integer.parseInt(strArray[0]);
        int N = Integer.parseInt(strArray[1]);
        int[][] box = new int[N][M];
        int[][] dist = new int[N][M];
        int[] dX = {1, -1, 0, 0};
        int[] dY = {0, 0, 1, -1};
        Integer[] cord;
        int maxDist = 0;
        int adjX = 0;
        int adjY = 0;

        //dist -1로 초기화
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        //box 입력값대로 초기화
        for (int i = 0; i < N; i++) {
            strArray = br.readLine().split(" ");
            int j = 0;
            for (String e : strArray) {
                box[i][j] = Integer.parseInt(e);
                if (box[i][j] == 1) {
                    queue.add(new Integer[]{i, j});
                    dist[i][j] = 0;
                }
                j++;
            }
        }

        while (!queue.isEmpty()) {
            cord = queue.poll();
         /*dfs... dist -1아니라도 만약 현재 탐색의 dist보다 크면 queue에 넣고
                                                      작으면 queue에 안넣음*/
            for (int k = 0; k < 4; k++) {
                adjX = cord[0] + dX[k];
                adjY = cord[1] + dY[k];
                if (adjX >= N || adjX < 0 || adjY >= M || adjY < 0) continue;
                if (box[adjX][adjY] == 0 && (dist[adjX][adjY] == -1 || dist[adjX][adjY] > dist[cord[0]][cord[1]] + 1)) {
                    queue.add(new Integer[]{adjX, adjY});
                    dist[adjX][adjY] = dist[cord[0]][cord[1]] + 1;
                }
            }
        }

        //전체 배열을 돌면서 0이 있는지 확인 있으면 최단거리 return, 없으면 -1 return
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
                if (box[i][j] == 0 && dist[i][j] == -1) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(maxDist);
    }
}

