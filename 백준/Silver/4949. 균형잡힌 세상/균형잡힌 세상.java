import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');

        String line;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        while(!(line = br.readLine()).equals(".")) {
            for(char c : line.toCharArray()) {
                if(c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == ']' || c == ')') {
                    if(stack.isEmpty() || stack.pop() != map.get(c)) {
                        sb.append("no").append("\n");
                        stack.clear();
                        break;
                    }
                } else if (c == '.') {
                    sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
                    stack.clear();
                }
            }
        }
        System.out.println(sb);
    }
}