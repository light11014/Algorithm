import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }

}