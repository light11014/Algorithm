import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//      1. 2부터 N까지 모든 정수를 적는다.
//      2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
//      3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
//      4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.

        boolean[] visited = new boolean[N + 1];

        int count = 0;

        for(int i = 2; i <= N; i++) {
            if(visited[i]) continue;

            for(int j = i; j <= N; j += i) {
                if(!visited[j]) {
                    visited[j] = true;
                    count++;

                    if(count == K) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }

    }

}