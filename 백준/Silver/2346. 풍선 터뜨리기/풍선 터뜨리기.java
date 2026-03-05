import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        HashMap<Integer, Integer> balloons = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
            balloons.put(i, Integer.parseInt(st.nextToken()));
        }

        StringBuilder answer = new StringBuilder();

        while(deque.size() > 1) {
            // 첫번째 풍선 꺼내기
            int ballon = deque.pollFirst();
            int k = balloons.get(ballon);
            answer.append(ballon).append(" ");

            if(k > 0) {
                // 양수면 앞에서 (k-1) 번 빼고 뒤에서 넣기
                for(int i = 0; i < k - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                // 음수면 뒤에서 |k| 번 빼서 앞으로 넣기
                for(int i = 0; i < (-1) * k; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        answer.append(deque.pollFirst());
        System.out.println(answer);
    }

}