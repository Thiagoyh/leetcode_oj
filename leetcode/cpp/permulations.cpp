#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        std::vector<std::vector<int>> res;
        if (nums.size() == 0) {
            return res;
        }
        std::vector<int> path;
        int map[21] = {0};
        for (int i = 0; i < nums.size(); i++) {
            map[nums[i] + 10]++;
        }
        process(res, path, nums, map);
        return res;
    }
    void process(std::vector<std::vector<int>>& res, std::vector<int>& path,
                 std::vector<int>& nums, int* map) {
        if (path.size() == nums.size()) {
            res.push_back(path);
            return;
        }
        int used[21] = {0};
        for (int i = 0; i < nums.size(); i++) {
            if (map[nums[i] + 10] == 0 || used[nums[i] + 10] == 1) {
                continue;
            }
            path.push_back(nums[i]);
            used[nums[i] + 10] = 1;
            map[nums[i] + 10]--;
            process(res, path, nums, map);
            path.pop_back();
            map[nums[i] + 10]++;
        }
    }
};