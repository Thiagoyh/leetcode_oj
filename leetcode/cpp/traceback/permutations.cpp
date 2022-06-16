#include <vector>

using namespace std;

class Solution {
public:
    int map[21] = {0};
    vector<vector<int>> permute(vector<int>& nums) {
        std::vector<std::vector<int>> res;
        if (nums.size() == 0) {
            return res;
        }
        std::vector<int> path;
        process(res, path, nums);
        return res;
    }
    void process(std::vector<std::vector<int>>& res, std::vector<int>& path,
                 std::vector<int>& nums) {
        if (path.size() == nums.size()) {
            res.push_back(path);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (map[nums[i] + 10] != 0) {
                continue;
            }
            path.push_back(nums[i]);
            map[nums[i] + 10] = 1;
            process(res, path, nums);
            path.pop_back();
            map[nums[i] + 10] = 0;
        }
    }
};