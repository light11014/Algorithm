import java.io.*;
import java.util.*;

public class Main {
    static int[][] wheels = new int[4][8];

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++) {
            String wheel = br.readLine();
            for(int j = 0; j < 8; j++) {
                wheels[i][j] = wheel.charAt(j) - '0';
            }
        }

        // 회전
        int K = Integer.parseInt(br.readLine());
        while(K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[4];
            dirs[num] = dir;

            // 왼쪽 전파
            for(int i = num; i > 0; i--) {
                if(wheels[i][6] != wheels[i - 1][2])
                    dirs[i - 1] = -dirs[i];
                else
                    break;
            }

            // 오른쪽
            for(int i = num; i < 3; i++) {
                if(wheels[i][2] != wheels[i + 1][6])
                    dirs[i + 1] = -dirs[i];
                else
                    break;
            }

            // 회전
            for(int i = 0; i < 4; i++) {
                if(dirs[i] != 0) {
                    rotate(i, dirs[i]);
                }
            }
        }

        // 점수 계산
        int answer = 0;
        int score = 1;
        for(int i = 0; i < 4; i++) {
            answer += score * wheels[i][0];
            score *= 2;
        }
        System.out.println(answer);
    }

    private static void rotate(int w, int dir) {
        if(dir == 1)
            rotateClockwise(w);
        else
            rotateAnticlockwise(w);
    }

    private static void rotateClockwise(int w) {
        int tmp = wheels[w][7];
        for(int i = 7; i > 0; i--)
            wheels[w][i] = wheels[w][i-1];
        wheels[w][0] = tmp;
    }

    private static void rotateAnticlockwise(int w) {
        int tmp = wheels[w][0];
        for(int i = 0; i < 7; i++)
            wheels[w][i] = wheels[w][i+1];
        wheels[w][7] = tmp;
    }
}