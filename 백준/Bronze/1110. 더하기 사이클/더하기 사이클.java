import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int newNum = N;

        do {
            newNum = makeNewNumber(newNum);
        } while(newNum != N);

        System.out.println(answer);
    }

    static int makeNewNumber(int pre) {
        answer++;
        if(pre < 10) {
            return pre * 10 + pre;
        }

        int a = pre / 10;
        int b = pre % 10;

        return b * 10 + (a + b) % 10;
    }

}