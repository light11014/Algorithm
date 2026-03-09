import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>(N);

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int answer = 0;

        for(int i = 0; i < M; i++) {
            if(set.contains(br.readLine()))
                answer++;

            if(answer == N)
                break;
        }

        System.out.println(answer);

    }

}