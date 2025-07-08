import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {

        // reader.readLine()
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // writer.append("").append("\n")
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // String -> int/long
        // int n = Integer.parseInt(reader.readLine());
        // long n = Long.parseLong(reader.readLine());

        // String -> int[]/long[]
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // long[] arr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();


        // print answer
        writer
                //.append("")		// .append(Integer.toString(1))
                .append(Integer.toString(arr[0]+arr[1]))
                .flush();
    }
}