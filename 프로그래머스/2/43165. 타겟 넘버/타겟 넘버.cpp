#include <string>
#include <vector>

using namespace std;

void dfs(const vector<int>& numbers, int depth, int sum, int target, int& answer) {
    if(depth == numbers.size()) {
        if(sum == target)
            answer++;
        return;
    }
    
    dfs(numbers, depth + 1, sum + numbers[depth], target, answer);
    dfs(numbers, depth + 1, sum - numbers[depth], target, answer);
}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    
    dfs(numbers, 0, 0, target, answer);
    
    return answer;
}

