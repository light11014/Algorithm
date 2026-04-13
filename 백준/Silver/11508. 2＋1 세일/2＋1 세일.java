import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        arr.sort((a, b) -> b - a);

        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(i % 3 != 0)
                answer += arr.get(i-1);
        }
        System.out.println(answer);
    }
}