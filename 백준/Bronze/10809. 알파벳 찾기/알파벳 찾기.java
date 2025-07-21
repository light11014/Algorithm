import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < 26; i++) {
            System.out.print(str.indexOf('a'+i) + " ");
        }
    }
}
