import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((N % 4 == 0 && N % 100 != 0 || N % 400 == 0)? 1 : 0);
    }
}