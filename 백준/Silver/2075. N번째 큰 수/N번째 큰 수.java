import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(table[b.row][b.col], table[a.row][a.col]));

        for(int i = 0; i < N; i++) {
            pq.add(new Node(N-1, i, table[N-1][i]));
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(pq.isEmpty()) break;

            Node cur = pq.poll();
            answer = table[cur.row][cur.col];

            int nr = cur.row-1;
            int nc = cur.col;

            if(nr >= 0)
                pq.add(new Node(nr, nc, table[nr][nc]));
        }

        System.out.println(answer);
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
        }
    }

}