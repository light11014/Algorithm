import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            int count = 0;
            for(char c : arr) {
                if(c == '(') {
                    count++;
                } else if(c == ')') {
                    if(--count < 0) {
                        break;
                    }
                }
            }
            System.out.println(count == 0? "YES" : "NO");
        }
    }
}