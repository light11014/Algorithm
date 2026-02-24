import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Comparator.comparingInt((Integer x) -> Math.abs(x))
                    .thenComparingInt(x -> x)
        );

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int op = Integer.parseInt(br.readLine());

            if(op == 0) {
                sb.append(pq.isEmpty()? 0 : pq.poll()).append("\n");
            } else {
                pq.add(op);
            }
        }

        System.out.println(sb);
    }
}