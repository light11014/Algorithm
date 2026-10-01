#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    unordered_set<string> used_words;
    
    char start = words[0][0];
    
    for(int i = 0; i < words.size(); i++) {
        if(words[i][0] == start
           && used_words.find(words[i]) == used_words.end()) {
            start = words[i].back();
            used_words.insert(words[i]);
        } else {
            return {i % n + 1, i / n + 1};
        }        
    }

    return {0, 0};
}