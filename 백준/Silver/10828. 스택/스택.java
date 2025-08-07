import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for(int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push": stack.push(Integer.parseInt(cmd[1])); break;
                case "pop" : System.out.println(stack.pop()); break;
                case "size": System.out.println(stack.size()); break;
                case "empty": System.out.println(stack.empty()); break;
                case "top": System.out.println(stack.top()); break;
            }
        }
    }

    static class Stack {
        private final List<Integer> list;

        Stack() {
            list = new ArrayList<>();
        }

        public void push(int X) {
            list.add(X);
        }

        public int pop() {
            return list.isEmpty()? -1 : list.remove(size()-1);
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return list.isEmpty()? 1 : 0;
        }

        public int top() {
            return list.isEmpty() ? -1 : list.get(size()-1);
        }
    }
}