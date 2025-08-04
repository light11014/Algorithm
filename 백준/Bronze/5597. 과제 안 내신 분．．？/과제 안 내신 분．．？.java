import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        int count = 0;
        for(int i = 1; i <= 30; i++) {
            if(!list.contains(i)) {
                System.out.println(i);
                if(++count == 2) break;
            }
        }
    }
}