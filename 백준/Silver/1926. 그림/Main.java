import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    final Integer[] X = {1, 0, -1, 0};
    final Integer[] Y = {0, 1, 0, -1};
    public int bfs(Queue<Integer[]>queue,int[][] arr, boolean[][] visited, Integer[] cord) {
        queue.add(cord);
        visited[cord[0]][cord[1]] = true;
        int graphSize = 1;

        while (!queue.isEmpty()) {
            cord = queue.poll();
            for (int i = 0; i < 4; i++) {
                Integer[] adjCord = {cord[0] + X[i], cord[1] + Y[i]};
                if (!isInRange(adjCord, arr)) continue;
                if (!visited[adjCord[0]][adjCord[1]] && arr[adjCord[0]][adjCord[1]] == 1) {
                    queue.add(adjCord);
                    visited[adjCord[0]][adjCord[1]] = true;
                    graphSize++;
                }
            }
        }

        return graphSize;
    }

    private boolean isInRange(Integer[] coordinate, int[][] arr) {
        return coordinate[0] < arr.length && coordinate[1] < arr[0].length && coordinate[0] >= 0 && coordinate[1] >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        String[] size = br.readLine().split(" ");
        final int COLUMN = Integer.parseInt(size[0]);
        final int ROW = Integer.parseInt(size[1]);
        int[][] arr = new int[COLUMN][ROW];
        boolean[][] visited = new boolean[COLUMN][ROW];//기본값 false로 초기화
        //상하좌우 좌표
        int graphCnt = 0;
        int maxGraphSize = 0;
        int graphSize = 0;
        Queue<Integer[]> queue = new LinkedList<>();

        /*입력 값 그래프에 저장*/
        for (int i = 0; i < COLUMN; i++) {
            String[] str = br.readLine().split(" ");
            int j = 0;
            for (String s : str) {
                arr[i][j++] = Integer.parseInt(s);
            }
        }
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                if (arr[i][j] == 0 || visited[i][j]) continue;
                graphSize = main.bfs(queue,arr, visited, new Integer[]{i, j});
                graphCnt++;
                maxGraphSize = Math.max(maxGraphSize, graphSize);
            }
        }

        System.out.println(graphCnt);
        System.out.print(maxGraphSize);
        br.close();
    }
}

