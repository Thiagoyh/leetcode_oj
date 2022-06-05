#include <iostream>
#include <queue>
#include <vector>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
    TreeNode(int val, TreeNode* left, TreeNode* right) :
             val(val), left(left), right(right) {}
};

class Solution {
public:
    std::vector<std::vector<int>> levelOrder(TreeNode* root) {
        std::vector<std::vector<int>> res;
        if (root == nullptr) {
            return res;
        }
        std::queue<TreeNode*> queue;
        queue.push(root);
        while (!queue.empty()) {
            std::vector<int> res_level;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode* cur = queue.front();
                queue.pop();
                res_level.push_back(cur->val);
                if (cur->left != nullptr)
                    queue.push(cur->left);
                if (cur->right != nullptr)
                    queue.push(cur->right);
            }
            res.push_back(res_level);
        }
        return res;
    }
     bool isSymmetric(TreeNode* root) {

    }
};