import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[n+1];
        int com[] = new int[m+1];

        combination(visited, com, 0, n, m);

    }

    static void combination(boolean visited[], int com[], int k, int n, int m) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(com[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                com[k] = i;
                combination(visited, com, k + 1, n, m);
                for (int j = i+1; j < n+1; j++) {
                    visited[j] = false;
                }
                //com[k] = 0 이런거 필요 없다. 어차피 덮어 씌워지기 때문
            }
        }
    }
}