import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 3으로 나누기 => 3의 배수만 가능
        // 2로 나누기 => 2의 배수만 가능
        // 1 빼기

        // 모든 경우의 수 다 해보기 => 완전 탐색
        // 너비 우선으로 찾으면 되네

        // 숫자가 되돌아 오는 것을 막아야함 => set
        HashSet<Integer> set = new HashSet<>();

        // 하나의 큐로는 구분 불가 => 상태 추가
        Deque<Node> que = new ArrayDeque<>();
        que.add(new Node(N, 0));
        set.add(N);

        while(!que.isEmpty()) {
            Node node = que.poll();
            int n = node.number;
            int d = node.depth;

            if(n == 1) {
                System.out.println(d);
                return;
            }

            if(n % 3 == 0 && !set.contains(n / 3)) {
                set.add(n/3);
                que.add(new Node(n/3, d+1));
            }
            if(n % 2 == 0 && !set.contains(n / 2)) {
                set.add(n/2);
                que.add(new Node(n/2, d+1));
            }
            if (!set.contains(n - 1)) {
                set.add(n-1);
                que.add(new Node(n-1, d+1));
            }
        }

    }

    static class Node {
        int number;
        int depth;

        Node(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }
}