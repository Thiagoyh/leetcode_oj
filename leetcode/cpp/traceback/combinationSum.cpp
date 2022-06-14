#include <vector>

using namespace std;

class Solution {
public:
    int start = 1;
    int end = 9;
    int sum = 0;
    vector<vector<int>> combinationSum3(int k, int n) {
        std::vector<std::vector<int>> res;
        std::vector<int> path;
        process(res, path, k, n, 1);
        return res;
    }
    void process(std::vector<std::vector<int>>& res, std::vector<int>& path,
                 int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) {
                res.push_back(path);
            }
            else {
                return;
            }
        }
        for (int i = startIndex; i <= end - (k - path.size()) + 1; ++i) {
            path.push_back(i);
            sum += i;
            process(res, path, k, n, i + 1);
            sum -= i;
            path.pop_back();
        }
    }
};