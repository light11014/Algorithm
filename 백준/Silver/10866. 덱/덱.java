import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque deque = new Deque();
        while(N-- > 0) {
            String input = br.readLine();

            if(input.contains("push_front")) {
                deque.pushFront(Integer.parseInt(input.substring(11)));
            } else if(input.contains("push_back")) {
                deque.pushBack(Integer.parseInt(input.substring(10)));
            } else if(input.equals("pop_front")) {
                System.out.println(deque.popFront());
            } else if(input.equals("pop_back")) {
                System.out.println(deque.popBack());
            } else if(input.equals("size")) {
                System.out.println(deque.size());
            } else if(input.equals("empty")) {
                System.out.println(deque.empty());
            } else if(input.equals("front")) {
                System.out.println(deque.front());
            } else if(input.equals("back")) {
                System.out.println(deque.back());
            }
        }
    }

    static class Deque {
        static int SIZE = 10000;
        int[] arr = new int[SIZE];
        int front = 0;
        int back = 1;

        public void pushFront(int x) {
            arr[front] = x;
            front = (front - 1 + SIZE) % SIZE;
        }

        public void pushBack(int x) {
            arr[back] = x;
            back = (back + 1) % SIZE;
        }

        public int popFront() {
            if(size() == 0) return -1;
            front = (front + 1) % SIZE;
            return arr[front];
        }

        public int popBack() {
            if(size() == 0) return -1;
            back = (back - 1 + SIZE) % SIZE;
            return arr[back];
        }

        public int size() {
            return (back - front - 1 + SIZE) % SIZE;
        }

        public int empty() {
            return size() == 0? 1 : 0;
        }

        public int front() {
            return size() == 0? -1 : arr[(front+1)%SIZE];
        }

        public int back() {
            return size() == 0? -1 : arr[(back-1 + SIZE)%SIZE];
        }


    }

}