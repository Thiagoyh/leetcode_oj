#include <vector>

using namespace std;

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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        std::vector<std::vector<int>> res;
        if (root == nullptr) {
            return res;
        }
        std::vector<int> path;
        path.push_back(root->val);
        process(root, res, path, targetSum - root->val);
        return res;
    }

    void process(TreeNode* root, std::vector<std::vector<int>>& res,
                 std::vector<int> path, int rest) {
        if (root->left == nullptr && root->right == nullptr && rest == 0) {
            res.push_back(path);
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            return;
        }

        if (root->left != nullptr) {
            path.push_back(root->left->val);
            rest -= root->left->val;
            process(root->left, res, path, rest);
            rest += root->left->val;
            path.pop_back();
        }
        if (root->right != nullptr) {
            path.push_back(root->right->val);
            rest -= root->right->val;
            process(root->right, res, path, rest);
            rest += root->right->val;
            path.pop_back();
        }
    }
};