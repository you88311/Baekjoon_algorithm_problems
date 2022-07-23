import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] cnt = new int[26];
        int index;

        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 97;
            cnt[index]++;
        }
        for (int e : cnt)
            System.out.print(e + " ");
    }
}
