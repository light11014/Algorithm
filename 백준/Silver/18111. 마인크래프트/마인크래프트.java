import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int minH = 256;
        int maxH = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        for (int h = minH; h <= maxH; h++) {
            int removed = 0;
            int needed = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;

                    if(diff > 0)
                        removed += diff; // 남으면 제거
                    else if(diff < 0)
                        needed -= diff; // 부족하면 추가
                }
            }

            if(B + removed < needed)
                continue;

            int curTime = removed * 2 + needed;

            if (curTime <= bestTime) {
                bestTime = curTime;
                bestHeight = h;
            }
        }
        System.out.println(bestTime + " " + bestHeight);
    }
}
