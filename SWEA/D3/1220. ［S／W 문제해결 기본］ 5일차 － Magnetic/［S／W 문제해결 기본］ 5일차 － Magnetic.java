import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] table = new int[N][N];

            int answer = 0;

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    table[r][c] = sc.nextInt();
                }
            }

            for(int c = 0; c < N; c++) {
                ArrayDeque<Integer> stack = new ArrayDeque<>();

                for (int r = 0; r < N; r++) {
                    if(table[r][c] == 1) {
                        stack.push(1);
                    } else if(!stack.isEmpty() && table[r][c] == 2) {
                        stack.clear();
                        answer++;
                    }
                }

            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}

