#include <bits/stdc++.h>
using namespace std;

int solution(string s)
{
    stack<char> st;
    
    for(char c : s) {
        if(st.empty()) {
            st.push(c);
        } else if (c == st.top()) {
            st.pop();
        } else{
            st.push(c);
        }
    }

    return st.empty();
}