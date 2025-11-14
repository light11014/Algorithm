import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int t = sc.nextInt();

            int[] score = new int[101];
            int answer = 0;
            int count = 0;
            for(int i = 0; i < 1000; i++) {
                score[sc.nextInt()]++;
            }

            for(int i = 0; i < score.length; i++) {
                if(count <= score[i]) {
                    answer = i;
                    count = score[i];
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}

