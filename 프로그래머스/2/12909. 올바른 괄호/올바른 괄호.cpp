#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    int open = 0;
    
    for(char c : s) {
        if(c == '(') {
            open++;
        } else {
            open--;
        }
        
        if(open < 0) {
            return false;
        }
    }
    
    return open == 0;
}