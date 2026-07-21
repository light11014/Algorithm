class Solution {
    public int solution(int number, int limit, int power) {
        // 1. 1부터 number까지 순회(기사 번호)
        // 2. 기사 번호를 기준으로 약수의 개수 구하기
        // 3. 약수의 개수에 따라서 answer 갱신
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int count = countFactors(i);
            answer += (count > limit)? power : count;
        }
        return answer;
    }
    
    private int countFactors(int num) {
        if(num == 1) return 1;

        int count = 0;
        
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                count += (i * i == num)? 1 : 2;
            }
        }
        
        return count;
    }
}