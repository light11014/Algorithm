import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];
       boolean[][] visited = new boolean[N][M];

        ArrayDeque<Point> queue = new ArrayDeque<>();
       for(int i = 0; i < N; i++) {
           String line = br.readLine();
           int idx = line.indexOf("I");
           if(idx != -1) {
               queue.add(new Point(i, idx));
               visited[i][idx] = true;
           }
           campus[i] = line.toCharArray();
       }

       int[] dx = {1, -1, 0, 0};
       int[] dy = {0, 0, 1, -1};

       int answer = 0;

       while(!queue.isEmpty()) {
           Point cur = queue.poll();

           for(int i = 0; i < 4; i++) {
               int nx = cur.x + dx[i];
               int ny = cur.y + dy[i];

               if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                   continue;

               if(visited[nx][ny] || campus[nx][ny] == 'X')
                   continue;

               if(campus[nx][ny] == 'P')
                   answer++;

               queue.add(new Point(nx, ny));
               visited[nx][ny] = true;
           }
       }

        System.out.println(answer == 0? "TT" : answer);

    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

}