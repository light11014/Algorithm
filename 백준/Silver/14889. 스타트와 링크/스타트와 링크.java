import java.io.*;
import java.util.*;

public class Main {
    static int[][] S;
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int start, int count) {
        if(count == N / 2) {
            // 시너지 계산 후 최소 값 갱신
            min = Math.min(min, calDiff());
            return;
        }

        for(int i = start; i < N; i++) {
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }

    private static int calDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        for(int i = 0; i < N-1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(selected[i] && selected[j])
                    startTeam += S[i][j] + S[j][i];
                else if(!selected[i] && !selected[j])
                    linkTeam += S[i][j] + S[j][i];
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}