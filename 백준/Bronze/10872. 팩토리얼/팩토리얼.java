import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 0) System.out.println(1);
        else {
            System.out.println(factorial(N));
        }
    }

    private static long factorial(long num) {
        if(num == 1) return 1;
        return num * factorial(num - 1);
    }
}