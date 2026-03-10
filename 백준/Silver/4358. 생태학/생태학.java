import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();

        String input;
        int total = 0;
        while((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()) {
            sb.append(key).append(" ").append(String.format("%.4f", (double)map.get(key) / total * 100)).append("\n");
        }

        System.out.println(sb);
    }

}