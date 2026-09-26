#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    int minNum = INT_MAX;
    int maxNum = INT_MIN;
    
    stringstream ss(s);
    
    int num;
    while(ss >> num) {
        minNum = min(num, minNum);
        maxNum = max(num, maxNum);
    }
    
    return to_string(minNum) + " " + to_string(maxNum);
}