#include <vector>

using namespace std;

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        if (bills[0] != 5) {
            return false;
        }
        std::vector<int> bill_map(2, 0);
        for (int i = 0; i < bills.size(); ++i) {
            if (bills[i] == 5) {
                bill_map[0]++;
            }
            else if (bills[i] == 10) {
                if (bill_map[0] == 0) {
                    return false;
                }
                bill_map[1]++;
                bill_map[0]--;
            }
            else {
                if (bill_map[0] == 0) {
                    return false;
                }
                if (bill_map[1] != 0) {
                    bill_map[1]--;
                    bill_map[0]--;
                }
                else {
                    if (bill_map[0] < 3) {
                        return false;
                    }
                    else {
                        bill_map[0] -= 3;
                    }
                }
            }
        }
        return true;
    }
};