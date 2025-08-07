import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> people = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            people.add(i + 1);
        }

        StringBuilder sb = new StringBuilder("<");
        int target = 0;
        while(people.size() > 1) {
            target = (target + K - 1) % people.size();
            sb.append(people.remove(target)).append(", ");
        }
        sb.append(people.get(0)).append(">");
        System.out.println(sb);
    }
}