import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                out.append(pq.isEmpty()? "0" : pq.remove()).append("\n");
            } else {
                pq.add(input);
            }
        }
        System.out.println(out);
    }
}