import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < board.length(); i++) {
            if(board.charAt(i) == '.') {
                sb.append(".");
                continue;
            }

            int count = 0;
            while(i < board.length() && board.charAt(i) == 'X') {
                count++;
                i++;
            }

            i--;

            if(count % 2 == 1) {
                System.out.println(-1); return;
            }

            while(count >= 4) {
                count -= 4;
                sb.append("AAAA");
            }

            if(count != 0) {
                sb.append("BB");
            }
        }

        System.out.println(sb);
    }
}