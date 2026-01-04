import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, String> pwMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            pwMap.put(input[0], input[1]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            sb.append(pwMap.get(find)).append("\n");
        }
        System.out.println(sb);
    }
}