/*
 * 遍历元素处理的模型
 */

#include <vector>

using namespace std;

class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        process(board);
    }
    bool process(std::vector<std::vector<char>>& board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (process(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    bool isValid(std::vector<std::vector<char>>& board, int row, int col, int val) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9方格里是否重复
            for (int j = startCol; j < startCol + 3; j++) {
               if (board[i][j] == val ) {
                  return false;
               }
            }
        }
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == val) {
                return false;
            }
        }
        for (int j = 0; j < 9; ++j) {
            if (board[row][j] == val) {
                return false;
            }
        }
        return true;
    }
};