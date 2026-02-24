import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;

        for (int i = 0; i < M - 2 * N; i++) {
            if(S.charAt(i) == 'O') continue;

            if(containsP(S, i, 2 * N + 1)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean containsP(String s, int start, int length) {
        char prev = 'I';

        for(int i = 1; i < length; i++) {
            char cur = s.charAt(start+i);

            if(cur == prev)
                return false;

            prev = cur;
        }

        return true;
    }
}