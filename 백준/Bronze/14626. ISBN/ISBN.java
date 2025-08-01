import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        int lostWeight = 1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '*') {
                lostWeight = (i % 2 == 0)? 1 : 3;
                continue;
            }
            sum += (str.charAt(i) - '0') * ((i % 2 == 0)? 1 : 3);
            sum %= 10;
        }

        for(int i = 0; i <= 9; i++) {
            if((lostWeight * i + sum) % 10 == 0) {
                System.out.println(i);
            }
        }
    }
}
