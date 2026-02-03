import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;
        for (int right = 0; right < N; right++) {
            // 과일 추가
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 과일 종류 2개 이상
            while(map.size() > 2) {
                // 과일 제거
                int count = map.get(fruits[left]);

                if(count == 1)
                    map.remove(fruits[left]);
                else
                    map.put(fruits[left], count-1);

                left++;
            }

            // 조건 만족
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}