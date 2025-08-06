import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            if(queue.size() == 1) break;
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());

    }
}