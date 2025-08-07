import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push": queue.push(Integer.parseInt(cmd[1])); break;
                case "pop" : sb.append(queue.pop()).append("\n"); break;
                case "size": sb.append(queue.size()).append("\n"); break;
                case "empty": sb.append(queue.empty()).append("\n"); break;
                case "front": sb.append(queue.front()).append("\n"); break;
                case "back": sb.append(queue.back()).append("\n"); break;
            }
        }
        System.out.println(sb);
    }

    static class Queue {
        private final List<Integer> list;

        Queue() {
            list = new ArrayList<>();
        }

        public void push(int X) {
            list.add(X);
        }

        public int pop() {
            return list.isEmpty()? -1 : list.remove(0);
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return list.isEmpty()? 1 : 0;
        }

        public int front() {
            return list.isEmpty() ? -1 : list.get(0);
        }

        public int back() {
            return list.isEmpty() ? -1 : list.get(size()-1);
        }
    }
}