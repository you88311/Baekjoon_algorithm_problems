import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] time = new int[200000];
        int cur;
        int next;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        if(n == k){
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 0; i < 3; i++) {
                if (i == 0)
                    next = cur + 1;
                else if (i == 1)
                    next = cur - 1;
                else
                    next = cur * 2;

                if (time.length > next && next >= 0) {
                    if(time[next] == 0) {
                        time[next] = time[cur] + 1;
                        queue.add(next);
                    }
                }

                if(next == k) {
                    System.out.println(time[next]);
                    return;
                }
            }
        }
    }
}