#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    vector<int> list;
    
    list.push_back(0);
    list.push_back(1);
    
    for(int i = 2; i <= n; i++) {
        list.push_back((list[i-1] + list[i-2]) % 1234567);
    }
    
    return list[n];
}