#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    unordered_map<string, int> wants;
    unordered_map<string, int> discounts;
    
    for(int i = 0; i < want.size(); i++) {
        wants[want[i]] = number[i];
    }
    
    for(int i = 0; i < discount.size(); i++) {
        discounts[discount[i]]++;
        
        if(i < 9) continue;
        
        if (i >= 10) {
            discounts[discount[i - 10]]--;
        }

        bool sign = true;
        
        for(const auto& p : wants) {
            if(p.second != discounts[p.first]) {
                sign = false;
                break;
            } 
        }
        
        if(sign)
            answer++;
    }
    
    return answer;
}