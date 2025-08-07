import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        for(String num : line.split(" ")) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        line = br.readLine();
        for(String num : line.split(" ")) {
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }
        System.out.println(sb);
    }
}