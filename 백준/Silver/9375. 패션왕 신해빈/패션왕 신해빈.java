import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer=1;

            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String type = br.readLine().split(" ")[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            for (int value : map.values()) {
                answer *= (value + 1);
            }

            System.out.println(answer-1);
        }

    }
}