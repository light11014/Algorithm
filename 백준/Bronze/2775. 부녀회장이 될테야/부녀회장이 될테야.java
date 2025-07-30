import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(calculatePeople(k, n));
        }
    }
    private static int calculatePeople(int a, int b) {
        if(a == 0) return b;
        else if(b == 1) return 1;
        else {
            int people = 0;
            for(int i = 1; i <= b; i++) {
                people += calculatePeople(a - 1, i);
            }
            return people;
        }
    }
}
