#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() == 1) {
            return 0;
        }
        int cur = 0;
        int next = 0;
        int res = 0;
        for (int i = 0; i < nums.size() - 1; ++i) {
            next = std::max(next, nums[i] + i);
            if (i == cur) {
                i++;
                cur = next;
            }
        }
        return res;
    }
};