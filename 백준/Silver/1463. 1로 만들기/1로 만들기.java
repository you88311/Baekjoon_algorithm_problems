import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(st.nextToken());
        int[] arr = new int[input+1];
        arr[1] = 0;

        for(int i = 2; i<= input; i++){
            arr[i] = arr[i-1] + 1;
            if(i%3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
            if(i%2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
        }

        System.out.println(arr[input]);
    }
}