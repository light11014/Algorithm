#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    for(int h = 1; h * h <= yellow; h++) {
        if(yellow % h == 0) {
            int w = yellow / h;
            
            if(brown == 2 * (w + h + 2))
                return {w + 2, h + 2};
        }
    }
    return {-1, -1};
}