import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = N;
        for(int five = N / 5; five >= 0; five--) {
            if((N - five * 5) % 3 == 0) {
                answer = Math.min(five + (N - five * 5) / 3, answer);
            }
        }
        System.out.println(answer == N? -1 : answer);
    }
}