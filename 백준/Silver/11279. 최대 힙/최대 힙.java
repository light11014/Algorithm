import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String input = br.readLine();
            if(input.equals("0")) {
                sb.append(pq.isEmpty()? 0 : pq.poll()).append("\n");
            } else {
                pq.add(Integer.parseInt(input));
            }
        }

        System.out.println(sb);

    }

}