import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
            g = gcd(g, Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                list.add(i);
                if (i != g / i) list.add(g / i);
            }
        }

        Collections.sort(list);
        for(int x : list)
            System.out.println(x);
    }

}