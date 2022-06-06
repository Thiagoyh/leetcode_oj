#include <queue>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int minDepth(TreeNode* root) {
         if (root == nullptr) {
             return 0;
         }
         return process(root);
    }
    int process(TreeNode* root) {
        if (root->left == nullptr && root->right == nullptr) {
            return 0;
        }
        int min = __INT32_MAX__;
        if (root->left == nullptr) {
            int depth = process(root->right);
            min = depth < min ? depth : min;
            return 1 + min;
        }
        if (root->right == nullptr) {
            int depth = process(root->left);
            min = depth < min ? depth : min;
            return 1 + min;
        }
        int left = process(root->left);
        int right = process(root->right);
        return 1 + std::min(left, right);
    }
};