import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringTokenizer st;

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] priorities = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int p = 0; p < N; p++) {
                priorities[p] = Integer.parseInt(st.nextToken());
                queue.add(p);
            }

            int answer = 0;
            while(!queue.isEmpty()) {
                int front = queue.poll();
                if(isMaximum(priorities, front)) {
                    answer++;
                    priorities[front] = -1;
                    if(front == M) {
                        System.out.println(answer);
                        break;
                    }
                } else {
                    queue.add(front);
                }
            }
            queue.clear();
        }
    }

    private static boolean isMaximum(int[] arr, int num) {
        for (int j : arr) {
            if (arr[num] < j) {
                return false;
            }
        }
        return true;
    }
}