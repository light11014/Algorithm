#include <bits/stdc++.h>

using namespace std;

void dfs(int k, const vector<vector<int>>& dungeons,
         vector<bool>& visited, int count, int& answer) {
    
    answer = max(answer, count);
    
    for(int i = 0; i < dungeons.size(); i++) {
        if(visited[i]) continue;
        if(k < dungeons[i][0]) continue;
        
        visited[i] = true;
        
        dfs(k - dungeons[i][1], dungeons, visited, count + 1, answer);
        
        visited[i] = false;
    }
} 

int solution(int k, vector<vector<int>> dungeons) {
    int answer = 0;
    
    vector<bool> visited(dungeons.size(), false);

    dfs(k, dungeons, visited, 0, answer);

    return answer;
}