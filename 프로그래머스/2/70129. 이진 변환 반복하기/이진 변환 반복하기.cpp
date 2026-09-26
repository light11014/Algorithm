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
    int convert_count = 0;
    int deleted_zero = 0;
    
    while(s != "1") {
        int one = count(s.begin(), s.end(), '1');
        
        deleted_zero += s.size() - one;
        convert_count++;
        
        s = toBinary(one);
    }
 
    return {convert_count, deleted_zero};
}

