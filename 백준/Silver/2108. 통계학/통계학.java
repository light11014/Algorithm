import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            int freq = map.getOrDefault(num, 0);
            map.put(num, freq + 1);
            if(freq + 1 > maxFreq) maxFreq = freq + 1;
        }

        Arrays.sort(arr);

        sb.append(Math.round((double) sum / N)).append('\n');
        sb.append(arr[N/2]).append('\n');

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() == maxFreq) {
                list.add(e.getKey());
            }
        }
        if(list.size() == 1)
            sb.append(list.get(0)).append('\n');
        else {
            Collections.sort(list);
            sb.append(list.get(1)).append('\n');
        }

        sb.append(arr[N-1] - arr[0]).append('\n');


        System.out.println(sb);
    }
}