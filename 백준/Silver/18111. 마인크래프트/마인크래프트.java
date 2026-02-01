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

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int h = minH; h <= maxH; h++) {
            int remove = 0;
            int put = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] > h) {
                        remove += map[i][j] - h;
                    } else if(map[i][j] < h){
                        put += h - map[i][j];
                    }
                }
            }

            if(B + remove - put < 0)
                continue;
            else if(time >= remove * 2 + put){
                time = remove * 2 + put;
                height = h;
            }
        }
        System.out.println(time + " " + height);
    }
}
