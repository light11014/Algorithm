#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> m;
    
    for(vector<string> cloth : clothes) {
        m[cloth[1]]++;
    }
    
    int answer = 1;
    
    for(auto p : m) {
        answer *= p.second + 1;
    }
    
    return answer - 1;
}