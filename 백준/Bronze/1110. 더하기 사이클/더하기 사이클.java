import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        int current = N;

        do {
            current = nextNumber(current);
            answer++;
        } while(current != N);

        System.out.println(answer);
    }

    static int nextNumber(int pre) {
        int tens = pre / 10;
        int ones = pre % 10;

        return ones * 10 + (tens + ones) % 10;
    }

}