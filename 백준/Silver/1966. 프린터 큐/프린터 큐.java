import java.io.*;
import java.util.*;

public class Main {
    static class Doc {
        int idx, pr;
        Doc(int idx, int pr) {
            this.idx = idx;
            this.pr = pr;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<Doc> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                pq.add(p);
                queue.addLast(new Doc(i, p));
            }

            int printed = 0;
            while (!queue.isEmpty()) {
                Doc cur = queue.pollFirst();
                if (cur.pr == pq.peek()) {
                    pq.poll();
                    printed++;
                    if(cur.idx == M) {
                        sb.append(printed).append('\n');
                        break;
                    }
                } else {
                    queue.addLast(cur);
                }
            }
        }
        System.out.println(sb);
    }
}