import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        long m = (long)A * B * C;
        int[] count = new int[10];

        while(m > 0) {
            count[(int)(m%10)]++;
            m /= 10;
        }

        for(int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}