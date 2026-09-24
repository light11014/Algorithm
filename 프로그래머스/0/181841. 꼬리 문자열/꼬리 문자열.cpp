#include <string>
#include <vector>

using namespace std;

size_t pos = 0;

string solution(vector<string> str_list, string ex) {
    string answer = "";
    
    for(const string& str : str_list) {
        if(str.find(ex) == string::npos)
            answer += str;
    }
    
    return answer;
}