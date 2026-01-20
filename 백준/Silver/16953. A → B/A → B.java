import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int count = 1;

        while(B > A) {
            if(B % 2 != 0 && B % 10 != 1) {
                System.out.println(-1);
                return;
            }
            while(B > A && B % 10 == 1) {
                B /= 10;
                count++;
            }
            while(B > A && B % 2 == 0) {
                B /= 2;
                count++;
            }
        }

        System.out.println(B == A? count : -1);
    }
}