import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque deque = new Deque();
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            String input = br.readLine();

            if(input.startsWith("push_front")) {
                deque.pushFront(Integer.parseInt(input.substring(11)));
            } else if(input.startsWith("push_back")) {
                deque.pushBack(Integer.parseInt(input.substring(10)));
            } else if(input.equals("pop_front")) {
                sb.append(deque.popFront()).append("\n");
            } else if(input.equals("pop_back")) {
                sb.append(deque.popBack()).append("\n");
            } else if(input.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if(input.equals("empty")) {
                sb.append(deque.empty()).append("\n");
            } else if(input.equals("front")) {
                sb.append(deque.front()).append("\n");
            } else if(input.equals("back")) {
                sb.append(deque.back()).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Deque {
        int[] arr = new int[20000];
        int front = 10000;
        int back = 10000;

        public void pushFront(int x) {
            arr[--front] = x;
        }

        public void pushBack(int x) {
            arr[back++] = x;
        }

        public int popFront() {
            if(size() == 0) return -1;
            return arr[front++];
        }

        public int popBack() {
            if(size() == 0) return -1;
            return arr[--back];
        }

        public int size() {
            return back - front;
        }

        public int empty() {
            return size() == 0? 1 : 0;
        }

        public int front() {
            return size() == 0? -1 : arr[front];
        }

        public int back() {
            return size() == 0? -1 : arr[back-1];
        }
    }
}