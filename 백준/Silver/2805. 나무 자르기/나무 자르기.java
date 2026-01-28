import java.io.*;
import java.util.*;

public class Main {
    static int[] trees;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long left = 0;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if(canMake(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canMake(long height) {
        long sum = 0;
        for (int tree : trees) {
            if(tree > height)
                sum += tree - height;
        }
        return sum >= M;
    }
}