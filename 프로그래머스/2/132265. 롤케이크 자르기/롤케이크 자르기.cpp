#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    
    unordered_map<int, int> right;
    for(int t : topping) {
        right[t]++;
    }
    
    unordered_set<int> left;
    for(int t : topping) {        
        if(--right[t] == 0)
            right.erase(t);
        
        left.insert(t);
        
        if(left.size() == right.size())
            answer++;
    }
    
    return answer;
}