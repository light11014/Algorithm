import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sizes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] units = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int T = units[0];
        int P = units[1];

        int order = 0;
        for (int i = 0; i < sizes.length; i++) {
            order += (sizes[i] + T - 1) / T;
        }
        System.out.println(order);
        System.out.println(N / P + " " + N % P);
    }
}