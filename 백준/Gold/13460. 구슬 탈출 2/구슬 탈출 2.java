import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int N, M;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int redR = 0, redC = 0, blueR = 0, blueC = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                board[i][j] = ch;

                if (ch == 'R') {
                    redR = i;
                    redC = j;
                    board[i][j] = '.';
                } else if (ch == 'B') {
                    blueR = i;
                    blueC = j;
                    board[i][j] = '.';
                }
            }
        }
        
        System.out.println(bfs(redR, redC, blueR, blueC));
    }

    static int bfs(int redR, int redC, int blueR, int blueC) {
        Queue<State> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.add(new State(redR, redC, blueR, blueC, 0));
        visited[redR][redC][blueR][blueC] = true;

        while(!queue.isEmpty()) {
            State cur = queue.poll();

            if(cur.depth == 10) continue;

            for(int dir = 0; dir < 4; dir++) {
                // 공 굴리기
                MoveResult nextRed = move(cur.rr, cur.rc, dir);
                MoveResult nextBlue = move(cur.br, cur.bc, dir);

                // 파랑이 구멍에 빠지면 실패
                if(nextBlue.hole)
                    continue;

                // 빨강이 구멍에 들어가면 성공
                if(nextRed.hole) {
                    return cur.depth + 1;
                }

                int nrr = nextRed.r;
                int nrc = nextRed.c;
                int nbr = nextBlue.r;
                int nbc = nextBlue.c;

                if(nrr == nbr && nrc == nbc) {
                    if(nextRed.dist > nextBlue.dist) {
                        nrr -= dr[dir];
                        nrc -= dc[dir];
                    } else {
                        nbr -= dr[dir];
                        nbc -= dc[dir];
                    }
                }

                if(!visited[nrr][nrc][nbr][nbc]) {
                    visited[nrr][nrc][nbr][nbc] = true;
                    queue.add(new State(nrr, nrc, nbr, nbc, cur.depth + 1));
                }

            }
        }
        return -1;
    }

    static class State {
        int rr, rc;
        int br, bc;
        int depth;

        public State(int rr, int rc, int br, int bc, int depth) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int r, c, dist;
        boolean hole;

        public MoveResult(int r, int c, int dist, boolean hole) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.hole = hole;
        }
    }



    static MoveResult move(int r, int c, int dir) {
        int nr = r;
        int nc = c;
        int dist = 0;

        while(true) {
            int nextR = nr + dr[dir];
            int nextC = nc + dc[dir];

            if(board[nextR][nextC] == '#')
                break;

            nr = nextR;
            nc = nextC;
            dist++;

            if(board[nr][nc] == 'O')
                return new MoveResult(nr, nc, dist, true);
        }

        return new MoveResult(nr, nc, dist, false);
    }


}