import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }

        arr.sort(Comparator.naturalOrder());

        long answer = (N % 2 == 0)? 0 : arr.get(N-1);
        int end = (N % 2 == 0)? N - 1 : N - 2;

        for(int i = 0; i < (end + 1) / 2; i++) {
            answer = Math.max(answer, arr.get(i) + arr.get(end - i));
        }
        System.out.println(answer);
    }
}