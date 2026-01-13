import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] pArr = new long[101];
        pArr[1] = 1;
        pArr[2] = 1;
        pArr[3] = 1;
        pArr[4] = 2;
        pArr[5] = 2;

        for(int i = 6; i <= 100; i++) {
            pArr[i] = pArr[i-1] + pArr[i-5];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(pArr[N]);
        }

    }

}