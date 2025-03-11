import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 실패율 구하기
        // 1-1. 스테이지 별로 몇명있는지 구하기
        int[] current = new int[N+2];
        for(int i = 0; i < stages.length; i++) {
            current[stages[i]]++;
        }
        
        // 1-2. 스테이지에 도달한 사람 구하기(누적)
        double total = stages.length;
        
        // 1-3. 계산하기
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            if(current[i] == 0) {
                map.put(i, 0.);
            } else {
                map.put(i, current[i]/total);
                total -= current[i];
            }
        }
        
        // 2. 실패율을 기준으로 스테이지 정렬하기
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, (o1, o2)-> Double.compare(o2.getValue(), o1.getValue()));
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
        
        // return map.entrySet().stream()
        //     .sorted((o1, o2)-> Double.compare(o2.getValue(), o1.getValue()))
        //     .mapToInt(HashMap.Entry::getKey).toArray();
    }
}