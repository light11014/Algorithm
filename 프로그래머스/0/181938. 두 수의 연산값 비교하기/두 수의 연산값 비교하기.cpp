#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int ab = 2 * a * b;
    int aplusb = stoi(to_string(a) + to_string(b));
    
    return aplusb >= ab? aplusb : ab;
}