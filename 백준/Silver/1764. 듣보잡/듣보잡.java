import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int M = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        Set<String> set = new HashSet<>();
        List<String> answer = new ArrayList<>();

        while (M-- > 0) {
            set.add(br.readLine());
        }

        while (N-- > 0) {
            String input = br.readLine();
            if(set.contains(input)) {
                answer.add(input);
            }
        }

        Collections.sort(answer);
        out.append(answer.size()).append('\n');
        answer.forEach(str -> out.append(str).append('\n'));
        System.out.println(out);
    }
}