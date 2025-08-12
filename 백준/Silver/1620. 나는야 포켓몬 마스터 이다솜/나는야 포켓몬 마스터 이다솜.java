import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int M = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        Map<String, Integer> nameToNum = new HashMap<>();
        String[] nameArr = new String[M];

        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            nameToNum.put(name, i+1);
            nameArr[i] = name;
        }

        while (N-- > 0) {
            String input = br.readLine();
            if(nameToNum.containsKey(input)) {
                out.append(nameToNum.get(input)).append('\n');
            } else {
                out.append(nameArr[Integer.parseInt(input) - 1]).append('\n');
            }
        }
        System.out.println(out);
    }
}