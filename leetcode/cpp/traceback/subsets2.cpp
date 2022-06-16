#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        std::vector<std::vector<int>> res;
        if (nums.size() == 0) {
            return res;
        }
        std::vector<int> path;
        std::sort(nums.begin(), nums.end());
        process(res, path, nums, 0);
        return res;
    }

    void process(std::vector<std::vector<int>>& res, std::vector<int>& path,
                 std::vector<int>& nums, int index) {
        if (index >= nums.size()) {
            if (path.size() >= 2) {
                res.push_back(path);
                return;
            }
            else return;
        }

        path.push_back(nums[index]);
        process(res, path, nums, index + 1);
        path.pop_back();

        int cur = index + 1;
        while (cur != nums.size()) {
            if (nums[cur] != nums[index]) {
                break;
            }
            cur++;
        }
        process(res, path, nums, cur);
    }
};