#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string is_suffix) {    
    if(my_string.length() < is_suffix.length()) return 0;
    
    for(int i = 0; i < is_suffix.length(); i++) {
        if(my_string[my_string.length() - is_suffix.length() + i] != is_suffix[i])
            return 0;
    }
    return 1;
}