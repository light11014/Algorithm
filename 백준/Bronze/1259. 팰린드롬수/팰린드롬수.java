import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        A: while(!(input = br.readLine()).equals("0")) {
            for(int f = 0, r = input.length() - 1; f < r; f++, r--) {
                if(input.charAt(f) != input.charAt(r)) {
                    System.out.println("no");
                    continue A;
                }
            }
            System.out.println("yes");
        }
    }
}