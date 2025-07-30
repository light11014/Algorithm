import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        long sum = 0;
        for(int i = 0; i < L; i++) {
            sum += (long) (((arr[i] - 'a' + 1) * Math.pow(31, i)) % 1234567891);
        }
        System.out.println(sum % 1234567891);
    }
}