import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] asc = {1,2,3,4,5,6,7,8};
        int[] desc = {8,7,6,5,4,3,2,1};

        if (Arrays.equals(input, asc)) {
            System.out.println("ascending");
        } else if (Arrays.equals(input, desc)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}