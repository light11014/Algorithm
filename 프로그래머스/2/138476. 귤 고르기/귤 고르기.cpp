#include <bits/stdc++.h>

using namespace std;

int solution(int k, vector<int> tangerine) {
    unordered_map<int, int> m;
    
    for(int t : tangerine) {
        m[t]++;
    }
    
    vector<int> v;
    
    for(const auto& p : m) {
        v.push_back(p.second);
    }
    
    sort(v.begin(), v.end(), greater<int>());
    
    int answer = 0;
    
    for(int count : v) {
        answer++;
        k -= count;
        
        if(k <= 0) {
            break;  
        }
    }
    
    return answer;
}