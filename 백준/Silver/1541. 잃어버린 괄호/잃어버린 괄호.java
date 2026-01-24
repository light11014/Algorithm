import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] minusSplit = input.split("-");

        int answer = sum(minusSplit[0]);

        for (int i = 1; i < minusSplit.length; i++) {
            answer -= sum(minusSplit[i]);
        }

        System.out.println(answer);
    }

    private static int sum(String str) {
        String[] plusSplit = str.split("\\+");
        int sum = 0;
        for (String num : plusSplit) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}

