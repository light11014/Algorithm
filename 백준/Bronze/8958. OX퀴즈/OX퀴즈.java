import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int score = 0;
            String str = br.readLine();
            int cnt = 0;
            for(char c : str.toCharArray()) {
                if(c == 'O') {
                    cnt++;
                    score += cnt;
                } else
                    cnt = 0;
            }
            System.out.println(score);
        }
    }
}