#include <vector>

using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; ++i) {
            cover = (nums[i] + i) > cover ? (nums[i] + i) : cover;
            if (cover >= nums.size() -1) {
                return true;
            }
        }
        return false;
    }
};