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
            // 시너지 계산
            int startTeam = 0;
            int linkTeam = 0;

            for(int i = 0; i < N - 1; i++) {
                if(selected[i]) {
                    for(int j = i + 1; j < N; j++) {
                        if(selected[j]) {
                            startTeam += S[i][j];
                            startTeam += S[j][i];
                        }
                    }
                } else {
                    for(int j = i + 1; j < N; j++) {
                        if(!selected[j]) {
                            linkTeam += S[i][j];
                            linkTeam += S[j][i];
                        }
                    }
                }
            }

            // 최소 값 갱신
            min = Math.min(Math.abs(startTeam - linkTeam), min);
            return;
        }

        for(int i = start; i < N; i++) {
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }


}