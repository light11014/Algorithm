import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int count = 0;
        int answer = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // '('면 push
            if(c == '(') {
                count++;
            } else { // ')' 일때,
                if(input.charAt(i-1) == '(') {
                    // 이전게 '(' 였음 => 레이저
                    answer += --count;

                } else { // 아니면 쇠막대기
                    answer++;
                    count--;
                }
            }
        }

        System.out.println(answer);
    }
}
