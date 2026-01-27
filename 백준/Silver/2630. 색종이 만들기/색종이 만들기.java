import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;

    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkColor(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    static void checkColor(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(paper[i][j] != color) {
                    int half = size / 2;
                    checkColor(x, y, half);
                    checkColor(x + half, y, half);
                    checkColor(x, y + half, half);
                    checkColor(x + half, y + half, half);
                    return;
                }
            }
        }

        if(color == 1) {
            blue++;
        } else {
            white++;
        }
    }
}
