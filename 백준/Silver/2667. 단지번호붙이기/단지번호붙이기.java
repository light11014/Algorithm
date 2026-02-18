import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        boolean[][] visited = new boolean[N][N];
        List<Integer> answer = new ArrayList<>();
        int total = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Queue<int[]> queue = new ArrayDeque<>();
                int count = 0;

                if(map[i][j] == '0' || visited[i][j]) {
                    continue;
                }

                queue.add(new int[]{i, j});
                visited[i][j] = true;
                count++;

                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for(int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '0' || visited[nx][ny]) {
                            continue;
                        }

                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }

                if(count != 0) {
                    answer.add(count);
                    total++;
                }

            }
        }

        answer.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");

        for(int i : answer) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

}