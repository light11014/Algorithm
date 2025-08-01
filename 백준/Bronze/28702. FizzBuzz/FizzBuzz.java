import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
            if(arr[i].matches("^[0-9]+$")) {
                System.out.println(toFizzBuzzString(arr[i], i));
                break;
            }
        }
    }

    private static String toFizzBuzzString(String str, int idx) {
        int N = Integer.parseInt(str) + (3 - idx);
        if(N % 3 == 0) {
            if(N % 5 == 0) {
                return "FizzBuzz";
            } else
                return "Fizz";
        } else if(N % 5 == 0) {
            return "Buzz";
        }
        return N + "";
    }
}