#include <vector>

using namespace std;

class Solution {
public:
    int map[201] = {0};
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        std::vector<std::vector<int>> res;
        if (nums.size() == 0) {
            return res;
        }
        std::vector<int> path;
        process(res, path, nums, 0);
        return res;
    }
    void process(std::vector<std::vector<int>>& res, std::vector<int>& path,
                 std::vector<int>& nums, int index) {
        if (path.size() > 1) {
            res.push_back(path);
        }

        int map[201] = {0};

        for (int i = index; i < nums.size(); ++i) {
            if ((path.size() != 0 && nums[index] < path[path.size() - 1]) ||
                map[nums[index] + 100] == 1) {
                    continue;
                }
            map[nums[i] + 100] = 1;
            path.push_back(nums[i]);
            process(res, path, nums, i + 1);
            path.pop_back();
        }

    }
};