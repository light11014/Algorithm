import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        StringBuilder out = new StringBuilder();
        out.append("<");
        while(queue.size() != 1) {
            for(int j = 0; j < K - 1; j++) {
                queue.add(queue.poll());
            }
            out.append(queue.poll()).append(", ");
        }
        out.append(queue.poll()).append(">");
        System.out.println(out);
    }
}