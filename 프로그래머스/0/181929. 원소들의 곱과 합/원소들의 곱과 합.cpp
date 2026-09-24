#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    int a = accumulate(num_list.begin(), num_list.end(), 0L);
    int b = accumulate(num_list.begin(), num_list.end(), 1, multiplies<int>());
    
    return a * a > b;
}