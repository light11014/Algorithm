#include<bits/stdc++.h>
using namespace std;

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};
    
    int n = maps.size();
    int m = maps[0].size();
    
    vector<vector<int>> dist(n, vector<int>(m, -1));
    queue<pair<int, int>> q;
    
    q.push({0, 0});
    dist[0][0] = 1;
    
    while(!q.empty()) {
        auto cur = q.front();
        q.pop();
        
        for(int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            
            if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;
            if(maps[nx][ny] == 0 || dist[nx][ny] > 0) continue;
            
            q.push({nx, ny});
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
        }
    }
    
    return dist[n-1][m-1];
}