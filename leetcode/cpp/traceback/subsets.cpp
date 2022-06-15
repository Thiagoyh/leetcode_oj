#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        std::vector<std::vector<int>> res;
        if (nums.size() == 0) {
            return res;
        }
        std::vector<int> space;
        process(res, space, nums, 0);
        return res;
    }

    void process(std::vector<std::vector<int>>& res, std::vector<int>& path,
                 std::vector<int>& nums, int index) {
        if (index >= nums.size()) {
            res.push_back(path);
            return;
        }
        path.push_back(nums[index]);
        for(int i = index; i < nums.size(); i++) {
            process(res, path, nums, i + 1);
        }
        path.pop_back();
        for(int i = index; i < nums.size(); i++) {
            process(res, path, nums, i + 1);
        }
    }
};