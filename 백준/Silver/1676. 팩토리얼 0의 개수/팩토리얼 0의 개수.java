import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ten = 0;
        int two = 0;
        int five = 0;

        for(int i = 2; i <= N; i++) {
            int num = i;

            while(num % 10 == 0) {
                num /= 10;
                ten++;
            }
            while(num % 2 == 0) {
                num /= 2;
                two++;
            }
            while(num % 5 == 0) {
                num /= 5;
                five++;
            }
        }

        System.out.println(ten + Math.min(two, five));
    }
}