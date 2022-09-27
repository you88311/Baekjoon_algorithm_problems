import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        if(m == 1) m = 2;

        for (int i = 2; i*i <= n; i++) {
            for (int j = i*i; j <= n; j+=i) {
                isPrime[j] = false;
            }
        }

        for (int i = m; i < isPrime.length; i++) {
            if(isPrime[i]) System.out.println(i);
        }

        return;
    }
}