#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    
    for(int i = 0; i < strArr.size(); i++) {
        for(char &c : strArr[i]) {
            c = i % 2 == 0? tolower(c) : toupper(c);
        }
    }
    
    return strArr;
}