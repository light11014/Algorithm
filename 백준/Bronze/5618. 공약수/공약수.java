import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        System.out.println(1);

        for(int i = 2; i <= nums[0]; i++) {
            boolean answer = true;

            for(int j = 0; j < N; j++) {
                if(nums[j] % i != 0) {
                    answer = false;
                    break;
                }
            }

            if(answer)
                System.out.println(i);
        }
    }

}