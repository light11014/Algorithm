#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1;
    
    for(int start = 1; start <= n / 2; start++) {
        int sum = 0;
        for(int i = start; i <= n; i++) {
            sum += i;
            
            if(sum == n) {
                answer++;
                break;
            } else if (sum > n) {
                break;
            }
        }
    }
    return answer;
}