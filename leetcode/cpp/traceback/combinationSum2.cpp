#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int map_used[51] = {0};
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        std::vector<std::vector<int>> res;
        if (candidates.size() == 0) {
            return res;
        }
        std::vector<int> path;
        std::sort(candidates.begin(), candidates.end());
        process(candidates, res, path, 0, target);
        return res;
    }
    void process(std::vector<int>& candidates, std::vector<std::vector<int>>& res,
                 std::vector<int>& path, int index, int rest) {
        if (rest == 0) {
            res.push_back(path);
            return;
        }
        if (rest < 0) {
            return;
        }
        if (index == candidates.size()) {
            return;
        }

        path.push_back(candidates[index]);
        process(candidates, res, path, index + 1, rest - candidates[index]);
        path.pop_back();

        int next = index + 1;
        while (next != candidates.size()) {
            if (candidates[next] == candidates[next - 1]) {
                next++;
            }
            else {
                break;
            }
        }
        process(candidates, res, path, next, rest);
    }
};