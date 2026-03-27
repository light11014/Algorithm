import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(long l = N; ;l++) {
            if (isPalindrome(l) && isPrime(l)) {
                System.out.println(l);
                return;
            }
        }
    }

    private static boolean isPrime(long l) {
        if(l == 1) return false;
        else if (l == 2 || l == 3) return true;
        else if(l % 2 == 0 || l % 3 == 0) return false;

        for(long i = 4; i * i <= l; i++) {
            if(l % i == 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(long l) {
        String str = l + "";
        for(int s = 0, e = str.length()-1; s < e; s++, e--) {
            if(str.charAt(s) != str.charAt(e)) {
                return false;
            }
        }
        return true;
    }
}