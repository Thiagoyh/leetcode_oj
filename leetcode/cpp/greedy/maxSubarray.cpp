#include <vector>

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        int index = 0;
        int sum = 0;
        int max = nums[0];
        while (index != nums.size()) {
            sum += nums[index];
            if (sum < 0) {
                max = sum > max ? sum : max;
                sum = 0;
            }
            max = sum > max ? sum : max;
        }
        return max;
    }
};