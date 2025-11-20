import java.util.*;

public class Solution {
    private static int N, L, answer;
    private static int[][] menu;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            L = sc.nextInt();

            menu = new int[N][2];
            answer = 0;

            for(int i = 0; i < N; i++) {
                menu[i][0] = sc.nextInt();
                menu[i][1] = sc.nextInt();
            }

            dfs(0, 0, 0);

            // 출력
            System.out.println("#" + t + " " + answer);
        }
    }

    private static void dfs(int like, int calorie, int start) {
        if(calorie > L) {
            return;
        }

        answer = Math.max(answer, like);

        for(int i = start; i < N; i++) {
            dfs(like + menu[i][0], calorie + menu[i][1], i + 1);
        }
    }
}
