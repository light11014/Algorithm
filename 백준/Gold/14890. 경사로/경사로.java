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
            int[] row = new int[N];
            int[] col = new int[N];

            for(int j = 0; j < N; j++) {
                row[j] = map[i][j];
                col[j] = map[j][i];
            }

            if (checkLine(row)) answer++;
            if (checkLine(col)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkLine(int[] line) {
        int height = line[0];
        int count = 1;

        for(int i = 1; i < N; i++) {
            int next = line[i];

            if(height == next) {
                // 같으면 통과
                count++;
            } else if(next == height + 1) {
                // 오르막
                if(count < L) return false;
                height = next;
                count = 1;
            } else if(next == height - 1) {
                // 내리막
                for(int l = 1; l < L; l++) {
                    if(i + l >= N || line[i+ l] != next) return false;
                }
                count = 0;
                height = next;
                i += L - 1;
            }  else {
                return false;
            }
        }

        return true;
    }
}