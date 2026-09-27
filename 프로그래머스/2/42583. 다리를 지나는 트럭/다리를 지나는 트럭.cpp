#include <bits/stdc++.h>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<int> trucks;
    for(int truck : truck_weights) {
        trucks.push(truck);
    }
    
    queue<int> bridge;
    for(int i = 0; i < bridge_length; i++) {
        bridge.push(0);
    }
    
    int total_weight = 0;
    int time = 0;
    
    while(!trucks.empty() || total_weight > 0) {
        time++;
        
        total_weight -= bridge.front();
        bridge.pop(); 
        
        if(!trucks.empty() 
           && total_weight + trucks.front() <= weight) {
            bridge.push(trucks.front());
            total_weight += trucks.front();
            trucks.pop(); 
        } else {
            bridge.push(0);
        }
    }
    
    return time;
}