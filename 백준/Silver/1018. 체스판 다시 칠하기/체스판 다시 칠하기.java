import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = N * M;
        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                answer = Math.min(answer, countRepaint(board, i, j, 'W'));
                answer = Math.min(answer, countRepaint(board, i, j, 'B'));
            }
        }
        System.out.println(answer);
    }

    private static int countRepaint(char[][] arr, int startX, int startY, char first) {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                char expected = (i + j) % 2 == 0 ? first : opposite(first);
                if(arr[startX+i][startY+j] != expected) {
                    count++;
                }
            }
        }
        return count;
    }

    private static char opposite(char c) {
        return (c == 'W') ? 'B' : 'W';
    }
}