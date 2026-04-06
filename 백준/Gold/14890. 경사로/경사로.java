import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(checkVertical(i)) answer++;
            if(checkHorizontal(i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkHorizontal(int r) {
        int height = map[r][0];
        int count = 1;

        for(int i = 1; i < N; i++) {
            int next = map[r][i];

            if(height == next) {
                // 같으면 통과
                count++;
            } else if(next == height - 1) {
                // 기준 높이보다 낮음
                for(int l = 1; l < L; l++) {
                    if(i + l >= N) return false;
                    if(map[r][i+l] != next) return false;
                }
                count = 0;
                height = next;
                i += L - 1;
            } else if(next == height + 1) {
                // 기준 높이보다 높음
                if(count < L) return false;
                count = 1;
                height = next;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean checkVertical(int c) {
        int height = map[0][c];
        int count = 1;

        for(int i = 1; i < N; i++) {
            int next = map[i][c];

            if(height == next) {
                // 같으면 통과
                count++;
            } else if(next == height - 1) {
                // 기준 높이보다 낮음
                for(int l = 1; l < L; l++) {
                    if(i + l >= N) return false;
                    if(map[i+l][c] != next) return false;
                }
                count = 0;
                height = next;
                i += L - 1;
            } else if(next == height + 1) {
                // 기준 높이보다 높음
                if(count < L) return false;
                count = 1;
                height = next;
            } else {
                return false;
            }
        }

        return true;
    }
}