import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            if(nums[0] == 0) return;

            Arrays.sort(nums);
            System.out.println(nums[0] * nums[0] + nums[1] * nums[1] == nums[2] * nums[2]? "right" : "wrong");
        }
    }
}