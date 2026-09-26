#include <bits/stdc++.h>

using namespace std;

string tobinary(int n);

int solution(int n) {
    int answer = 0;
    
    string binary_n = tobinary(n);
    int one_count = count(binary_n.begin(), binary_n.end(), '1');
    
    int next_num = n;
    
    int next_count;
    do {
        next_num++;
        
        string binary_next = tobinary(next_num);
        next_count = count(binary_next.begin(), binary_next.end(), '1');
        
    } while(next_count != one_count);
    
    return next_num;
}

string tobinary(int n) {
    string result;
    
    while(n > 0) {
        result += (n % 2) + '0';
        n /= 2;
    }
    
    reverse(result.begin(), result.end());
    
    return result;
}