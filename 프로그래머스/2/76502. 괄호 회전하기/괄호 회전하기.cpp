#include <bits/stdc++.h>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    string double_s = s + s;
    
    unordered_map<char, char> m;
    m['['] = ']';
    m['{'] = '}';
    m['('] = ')';
    
    for(int start = 0; start < s.size(); start++) {
        stack<char> st;
        
        bool right = true;
        
        for(int i = start; i < start + s.size(); i++) {
            char c = double_s[i];
            
            if(c == '[' || c == '{' || c == '(')
                st.push(c);
            else if (!st.empty() && m[st.top()] == c)
                st.pop();
            else {
                right = false;
                break;
            }
        }
        
        if(right && st.empty())
            answer++;
    }
    
    return answer;
}