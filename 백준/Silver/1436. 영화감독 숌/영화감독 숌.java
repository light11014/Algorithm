import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 666;
        int count = 1;
        while(count <= N) {
            if(String.valueOf(answer).contains("666")) {
                count++;
            }
            answer++;
        }

        System.out.println(answer-1);
    }
}