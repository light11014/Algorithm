import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int value = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
            answer = answer * B + value;
        }

        System.out.println(answer);
    }
}