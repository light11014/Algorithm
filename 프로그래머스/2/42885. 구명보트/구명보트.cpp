#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end());
    
    int s = 0;
    int e = people.size() - 1;
    
    int answer = 0;
    
    while(s <= e) {
        if(s < e && people[s] + people[e] <= limit) {
            s++;        
        }
        
        e--;
        answer++;
    }
    
    return answer;
}