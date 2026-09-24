#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    
    for(int i = 0; i < strArr.size(); i++) {
        if(i % 2 == 0) {
            for(char &c : strArr[i]) {
                c = tolower(c);
            }
        }
        else {
            for(char &c : strArr[i]) {
                c = toupper(c);
            }
        } 
    }
    
    return strArr;
}