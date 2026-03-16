import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        int n = 1;

        for(int i = N.length()-1 ; i >= 0; i--) {
            char c = N.charAt(i);
            answer += n * (Character.isDigit(c)? c-'0' : 10 + c - 'A');
            n *= B;
        }

        System.out.println(answer);
    }

}