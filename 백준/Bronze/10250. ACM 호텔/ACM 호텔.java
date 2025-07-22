import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int room = (int)Math.ceil((double)input[2] / input[0]);
            int floor = input[2] % input[0];
            System.out.println((floor == 0? input[0] : floor) * 100 + room);
        }
    }
}