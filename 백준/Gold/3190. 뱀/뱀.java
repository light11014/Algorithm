import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Deque<Point> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];


        // 사과: 2
        while(K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            board[i][j] = 2;
        }

        int L = Integer.parseInt(br.readLine());

        Map<Integer, Integer> dirMap = new HashMap<>();
        while(L-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int second = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().equals("L")? -1 : 1;

            dirMap.put(second, dir);
        }

        snake = new ArrayDeque<>();
        snake.add(new Point(1, 1));

        int dir = 0;

        int count = 0;
        while(true) {
            // 방향 확인
            dir = (dir + dirMap.getOrDefault(count, 0) + 4) % 4;

            // 방향쪽으로 한칸 이동
            if(move(dir)) {
                count++;
            } else {
                System.out.println(count + 1);
                return;
            }
        }
    }

    private static boolean move(int dir) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        if(snake.isEmpty()) return false;

        // 머리
        Point head = snake.getFirst();

        // 새로운 머리의 좌표
        int nx = head.x + dx[dir];
        int ny = head.y + dy[dir];

        // 벽에 부딪힘 & 몸에 부딪힘
        if(nx <= 0 || nx > N || ny <= 0 || ny > N || board[nx][ny] == 1) {
            return false;
        }

        // 머리 이동
        snake.addFirst(new Point(nx, ny));
        if(board[nx][ny] != 2) {
            // 사과가 없으면 꼬리 줄기
            Point tail = snake.removeLast();
            board[tail.x][tail.y] = 0;
        }
        board[nx][ny] = 1;

        return true;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}