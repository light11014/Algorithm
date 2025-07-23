import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;
        while(sum < N) {
            sum += 6 * (count++);
        }
        System.out.println(count);
    }
}