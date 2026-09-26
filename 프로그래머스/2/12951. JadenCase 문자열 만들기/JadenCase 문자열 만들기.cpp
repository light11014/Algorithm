#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    bool start = false;
    
    for(char& c : s) {
        if(c == ' ') {
            start = false;
            continue;
        }
        
        if(start) {
            c = tolower(c);
        } else {
            c = toupper(c);
            start = true;
        }
    }
    
    return s;
}