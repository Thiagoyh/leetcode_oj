#include <vector>

using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int index = 0, start = 0;
        int rest = 0;
        while (index != gas.size()) {
            if (rest < 0) {
                rest = 0;
                start = index;
            }
            rest += gas[index];
            rest -= cost[index];
            index++;
        }
        for (int i = 0; i <= start; i++) {
            if (rest < 0) {
                return -1;
            }
            rest += gas[i];
            rest -= cost[i];
        }
        return start;
    }
};