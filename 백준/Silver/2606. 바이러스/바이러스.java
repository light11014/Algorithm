import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());

        // 연결 그래프
        ArrayList<ArrayList<Integer>> graph
                = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < L ;i ++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // 양방향
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // dfs, stack, 재귀함수
        boolean[] visited = new boolean[N+1];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        visited[1] = true;
        int answer = 0;

        while(!stack.isEmpty()) {
            // 현재 방문
            int cur = stack.pop();

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    stack.push(next);
                    visited[next] = true; // 스택에 넣는 순간 true (예약 처리되 노드)
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}