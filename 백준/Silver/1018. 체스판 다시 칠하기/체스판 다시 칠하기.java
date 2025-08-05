import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] board = new String[N][M];

        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        int answer = N * M;
        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                answer = Math.min(answer, countRepaint(board, i, j, "W", answer));
                answer = Math.min(answer, countRepaint(board, i, j, "B", answer));
            }
        }
        System.out.println(answer);
    }

    private static int countRepaint(String[][] arr, int startX, int startY, String type, int min) {
        int count = 0;
        String even = type;
        String odd = type.equals("W")? "B" : "W";
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(!arr[startX+i][startY+j].equals(((i+j)%2 == 0)? even : odd)) {
                    count++;
                    if(count == min) {
                        return count;
                    }
                }
            }
        }
        return count;
    }
}