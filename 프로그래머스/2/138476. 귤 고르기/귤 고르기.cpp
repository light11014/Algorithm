#include <bits/stdc++.h>

using namespace std;

int solution(int k, vector<int> tangerine) {
    // 종류별 귤 개수 세기 <type, count>
    unordered_map<int, int> m;
    
    for(int t : tangerine) {
        m[t]++;
    }
    
    // value => count 많은 순으로 정렬 
    vector<pair<int, int>> v(m.begin(), m.end());
    
    sort(v.begin(), v.end(), [](const auto& a, const auto& b) {
        return a.second > b.second; 
    });
    
    // 많은 순부터 k개 고르기
    int answer = 0;
    
    for(const auto& p : v) {
        answer++;
        k -= p.second;
        
        if(k <= 0) {
            break;  
        }
    }
    
    return answer;
}