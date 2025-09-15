import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>();

        for(String n : line) {
            set.add(Integer.parseInt(n));
        }

        StringBuilder out = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        for(String n : line) {
            out.append(set.contains(Integer.parseInt(n))? 1 : 0).append(" ");
        }
        System.out.println(out);
    }
}