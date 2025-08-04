import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int two = 0;
        int five = 0;

        for(int i = 2; i <= N; i++) {
            int num = i;
            two += countFactor(num, 2);
            five += countFactor(num, 5);
        }

        System.out.println(Math.min(two, five));
    }
    
    private static int countFactor(int num, int factor) {
        int count = 0;
        while(num % factor == 0) {
            num /= factor;
            count++;
        }
        return count;
    }
}