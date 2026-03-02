import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue();

        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            String input = br.readLine();

            if(input.startsWith("push")) {
                queue.push(Integer.parseInt(input.split(" ")[1]));
            } else if(input.equals("pop")) {
                sb.append(queue.pop()).append("\n");
            } else if(input.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if(input.equals("empty")) {
                sb.append(queue.empty()).append("\n");
            } else if(input.equals("front")) {
                sb.append(queue.front()).append("\n");
            } else if(input.equals("back")) {
                sb.append(queue.back()).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Queue {
        int[] arr = new int[2000000];
        int front = 0;
        int rear = 0;

        public void push(int num) {
            arr[rear++] = num;
        }

        public int pop() {
            return empty() == 1? -1 : arr[front++];
        }

        public int size() {
            return rear - front;
        }


        public int empty() {
            return size() == 0? 1 : 0;
        }

        public int front() {
            return empty() == 1? -1 : arr[front];
        }

        public int back() {
            return empty() == 1? -1 : arr[rear - 1];
        }
    }
}
