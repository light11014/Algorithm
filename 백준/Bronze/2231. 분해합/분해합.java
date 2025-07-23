import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++) {
            int temp = i;
            int sum = i;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if(sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}