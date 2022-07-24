import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int commandCnt = Integer.parseInt(br.readLine());
        String command = null;
        String last = "";

        while (commandCnt-- != 0) {
            command = br.readLine();

            if (command.equals("pop")) {
                if (!queue.isEmpty()) {
                    bw.write(Integer.toString(queue.poll()));
                } else {
                    bw.write("-1");
                }
                bw.newLine();
            } else if (command.equals("size")) {
                bw.write(Integer.toString(queue.size()));
                bw.newLine();
            } else if (command.equals("empty")) {
                bw.write(Integer.toString(queue.size() == 0 ? 1 : 0));
                bw.newLine();
            } else if (command.equals("front")) {
                if (!queue.isEmpty()) {
                    bw.write(Integer.toString(queue.peek()));
                } else {
                    bw.write("-1");
                }
                bw.newLine();
            } else if (command.equals("back")) {
                if (!queue.isEmpty()) {
                    bw.write(last);
                } else {
                    bw.write("-1 ");
                }
                bw.newLine();
            } else if (command.startsWith("push")) {
                String[] arr = command.split(" ");
                last = arr[1];
                queue.add(Integer.parseInt(last));
            }
        }

        bw.flush();
        bw.close();
    }
}

