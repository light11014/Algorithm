#include <bits/stdc++.h>

using namespace std;

int solution(int n) {
    int one_count = __builtin_popcount(n);
    
    int next_num = n + 1;
    
    while(one_count != __builtin_popcount(next_num)) {
        next_num++;
    }

    return next_num;
}