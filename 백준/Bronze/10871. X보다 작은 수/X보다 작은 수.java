import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(num < X) {
                System.out.print(num + " ");
            }
        }
    }
}