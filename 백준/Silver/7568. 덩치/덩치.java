import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];
        int[] rank = new int[N];

        for(int i = 0; i < N; i++) {
            rank[i] = 1;
            arr[i] = new int[2];
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank[i]++;
                } else if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    rank[j]++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}