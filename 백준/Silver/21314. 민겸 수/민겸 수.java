import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 최대: K를 기준으로 끊는다.
        // 최소: M 합쳐서, K = 5
        StringBuilder maxStr = new StringBuilder();
        StringBuilder minStr = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == 'M') {
                count++;
            } else { // K
                if (count != 0) {
                    maxStr.append(5).append("0".repeat(count));
                    minStr.append(1).append("0".repeat(count-1)).append(5);
                } else {
                    maxStr.append(5);
                    minStr.append(5);
                }
                count = 0;
            }
        }
        if(count != 0) {
            maxStr.append("1".repeat(count));
            minStr.append("1").append("0".repeat(count-1));
        }

        System.out.println(maxStr);
        System.out.println(minStr);
    }
}