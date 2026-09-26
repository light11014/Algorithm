#include <bits/stdc++.h>

using namespace std;

string toBinary(int n) {
    string result;
    
    while(n > 0) {
        result += (n % 2) + '0';
        n /= 2;
    }
    
    reverse(result.begin(), result.end());
    
    return result;
}

vector<int> solution(string s) {
    vector<int> answer;
    
    int count = 0;
    int deleted_zero = 0;
    while(true) {
        count++;
        int one = 0;
        
        for(char& c : s) {
            if(c == '1') {
               one++; 
            }
        }
        
        deleted_zero += s.length() - one;
        
        if(one == 1) {
            answer.push_back(count);
            answer.push_back(deleted_zero);
            break;
        }
        
        s = toBinary(one);
    }
    
    return answer;
}

