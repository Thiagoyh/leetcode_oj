#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        std::vector<std::vector<int>> res;
        std::vector<int> path;
        if (k > n) {
            return res;
        }
        process(res, path, 1, n, k);
        return res;
    }
    void process(std::vector<std::vector<int>>& res, std::vector<int> path,
                 int start, int end, int k) {
        if (end - start + 1 < k) {
            return;
        }
        if (k == 1) {
            for (int i = start; i <= end; i++) {
                path.push_back(i);
                res.push_back(path);
                path.pop_back();
            }
            return;
        }
        if (k == 0) {
            return;
        }
        path.push_back(start);
        process(res, path, start + 1, end, k - 1);
        path.pop_back();

        process(res, path, start + 1, end, k);
    }

    void process2(std::vector<std::vector<int>>& res, std::vector<int> path,
                 int n, int k, int start) {
                     if (path.size() == k) {
                         res.push_back(path);
                         return;
                     }
                     for (int i = start; i <= n; i++) {
                         path.push_back(i);
                         process2(res, path, n, k, i + 1);
                         path.pop_back();
                     }
                 }
};