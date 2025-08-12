import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[20];
        for(int i = 0; i < 20; i++) {
            arr[i] = false;
        }

        while (M-- > 0) {
            String[] line = br.readLine().split(" ");
            String func = line[0];
            int x = (line.length == 2)? Integer.parseInt(line[1]) : 0;
            switch (func) {
                case "add":
                    arr[x-1] = true;
                    break;
                case "remove":
                    arr[x-1] = false;
                    break;
                case "check":
                    out.append(arr[x - 1] ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    arr[x-1] = !arr[x-1];
                    break;
                case "all":
                    for(int i = 0; i < 20; i++) {
                        arr[i] = true;
                    }
                    break;
                case "empty":
                    for(int i = 0; i < 20; i++) {
                        arr[i] = false;
                    }
                    break;
            }
        }
        System.out.println(out);
    }
}