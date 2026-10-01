#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> elements) {
    unordered_set<int> set;
    
    for(int start = 0; start < elements.size(); start++) {
        int sum = 0;   
        for(int i = 0; i < elements.size(); i++) {
            sum += elements[(start + i) % elements.size()]; 
            set.insert(sum);
        }
    }
    
    return set.size();
}