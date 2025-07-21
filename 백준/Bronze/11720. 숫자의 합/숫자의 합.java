import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += numStr.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
