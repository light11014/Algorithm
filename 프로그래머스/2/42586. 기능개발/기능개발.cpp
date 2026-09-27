#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<pair<int, int>> q;
    
    for(int i = 0; i < progresses.size(); i++) {
        q.push({progresses[i], speeds[i]});
    }
    
    while(!q.empty()) {
        int q_size = q.size();
        
        for(int i = 0; i < q_size; i++) {
            pair<int, int> cur = q.front();
            q.pop();
            
            q.push({cur.first + cur.second, cur.second});
        }
        
        int count = 0;
        
        while(!q.empty() && q.front().first >= 100) {
            q.pop();
            count++;
        }
        
        if(count > 0)
            answer.push_back(count);
    }
    
    return answer;
}