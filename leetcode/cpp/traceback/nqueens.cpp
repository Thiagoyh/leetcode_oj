#include <vector>
#include <string>
#include <algorithm>

// 典型 i 到 i + 1尝试模型

using namespace std;

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        std::vector<std::vector<std::string>> res;
        if (n == 1) {
            res.push_back({"Q"});
            return res;
        }
        if (n == 2 || n == 3) {
            return res;
        }

        int* record = new int[n];
        for (int i = 0; i < n; ++i) {
            record[i] = 0;
        }
        std::vector<int> path_int;
        std::vector<std::vector<int>> res_int;
        process(res_int, path_int, record, 0, n);
        for (int i = 0; i < res_int.size(); i++) {
            std::vector<std::string> path(n, std::string(n, '.'));
            for (int j = 0; j < n; j++) {
                path[j][res_int[i][j]] = 'Q';
            }
            res.push_back(path);
        }

        return res;
    }

    void process(std::vector<std::vector<int>>& res,
                 std::vector<int>& path,
                 int* map, int row, int n) {
        if (row == n) {
            res.push_back(path);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(map, row, j)) {
                map[row] = j;
                path.push_back(j);
                process(res, path, map, row + 1, n);
                path.pop_back();
            }
        }

    }

    bool isValid(int* map, int row, int col) {
        for (int k = 0; k < row; k++) {
            if (col == map[k] || std::abs(map[k] - col) == std::abs(row - k)) {
                return false;
            }
        }
        return true;
    }
};