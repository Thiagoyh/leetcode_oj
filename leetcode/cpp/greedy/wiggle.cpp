#include <vector>

using namespace std;

class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        if (nums.size() <= 1) {
            return nums.size();
        }
        int pre = 0;
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.size() - 1; ++i) {
            cur = nums[i + 1] - nums[i];
            if ((cur > 0 && pre <= 0) || cur < 0 && pre >= 0) {
                count++;
                pre = cur;
            }
        }
        return count;
    }
};