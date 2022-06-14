#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        std::vector<std::vector<int>> res;
        if (candidates.size() == 0) {
            return res;
        }
        std::vector<int> path;
        process(candidates, res, path, 0, target);
        return res;
    }
    void process(std::vector<int>& candidates, std::vector<std::vector<int>>& res,
                 std::vector<int>& path, int index, int rest) {
        if (rest == 0) {
            res.push_back(path);
        }
        if (rest < 0) {
            return;
        }
        if (index == candidates.size()) {
            return;
        }
        for (int i = 0; i <= rest / candidates[index]; ++i) {
            for (int j = 0; j < i; j++) {
                path.push_back(candidates[index]);
            }
            process(candidates, res, path, index + 1, rest - candidates[index] * i);
            for (int j = 0; j < i; j++) {
                path.pop_back();
            }
        }
    }
};