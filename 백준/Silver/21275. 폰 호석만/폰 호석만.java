import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static int charToValue(char ch) {
        if ('0' <= ch && ch <= '9') return ch - '0';
        return ch - 'a' + 10;
    }

    private static boolean check(String str, int radix) {
        for(char c : str.toCharArray()) {
            int val = charToValue(c);
            if(val >= radix) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();


        int count = 0;
        BigInteger answer = BigInteger.ZERO;
        int aRadix = 0;
        int bRadix = 0;

        for(int i = 2; i <= 36; i++) {
           if(!check(a, i)) continue;
           BigInteger A = new BigInteger(a, i);

           for(int j = 2; j <= 36; j++) {
                if(i == j) continue;
                if(!check(b, j)) continue;

               BigInteger B = new BigInteger(b, j);

               if (A.equals(B)) {
                   count++;
                   answer = A;
                   aRadix = i;
                   bRadix = j;
               }
           }
        }

        if(count == 0)
            System.out.println("Impossible");
        else if(count == 1)
            System.out.println(answer + " " + aRadix + " " + bRadix);
        else
            System.out.println("Multiple");

    }
}