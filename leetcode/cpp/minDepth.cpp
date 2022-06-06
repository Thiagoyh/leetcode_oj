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
        if (root == nullptr) {
            return 0;
        }
        int left = process(root->left);
        int right = process(root->right);

        if (root->left == nullptr && root->right != nullptr) {
            return 1 + right;
        }
        if (root->left != nullptr && root->right == nullptr) {
            return 1 + left;
        }

        return (1 + std::min(left, right));
    }
};