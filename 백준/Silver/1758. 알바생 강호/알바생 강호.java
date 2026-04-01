import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> tips = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }

        tips.sort(Comparator.reverseOrder());

        long answer = 0;
        for(int i = 0; i < N; i++) {
            int tip = tips.get(i);
            answer += Math.max(tip - i, 0);
        }

        System.out.println(answer);

    }
}