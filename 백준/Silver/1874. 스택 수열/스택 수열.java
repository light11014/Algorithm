import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int stackNum = 1;
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            // push
            while(stack.isEmpty() || stackNum <= cur) {
                stack.push(stackNum++);
                sb.append("+").append("\n");
            }
            
            // pop
            int top = stack.pop();
            if(top == cur) {
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}