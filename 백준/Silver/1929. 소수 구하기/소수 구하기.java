import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        boolean isPrime;
        if(m == 1) m = 2;
        
        for(int i = m; i <= n ; i++){
            isPrime = true;
            int sqrt = (int)Math.sqrt(i);
            for(int j = 2; j <= sqrt; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) System.out.println(i);
        }

        return;
    }
}