import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int answer = 0;
        for(int i = 0; i < cards.length - 2; i++) {
            if(cards[i] >= M)
                continue;

            for(int j = i + 1; j < cards.length - 1; j++) {
                if(cards[i] + cards[j] >= M)
                    continue;

                for(int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M) {
                        answer = Math.max(sum, answer);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}