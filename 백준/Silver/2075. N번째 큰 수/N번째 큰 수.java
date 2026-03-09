import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(input[j]);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.value - a.value);

        for(int i = 0; i < N; i++) {
            pq.add(new Node(N-1, i, table[N-1][i]));
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(pq.isEmpty()) break;

            Node cur = pq.poll();
            answer = cur.value;

            int nr = cur.row-1;
            int nc = cur.col;

            if(nr < 0 || nc < 0) continue;

            pq.add(new Node(nr, nc, table[nr][nc]));
        }

        System.out.println(answer);
    }

    static class Node {
        int row;
        int col;
        int value;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

}