class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            if(num % 2 == 0) {
                answer[i] = num + 1;
                continue;
            }
            
            String binary = "0" + Long.toBinaryString(num);
            int idx = binary.lastIndexOf("01");
            
            String result = binary.substring(0, idx)
                            + "10"
                            + binary.substring(idx + 2);
            
            answer[i] = Long.parseLong(result, 2);
        }
        
        return answer;
    }
}