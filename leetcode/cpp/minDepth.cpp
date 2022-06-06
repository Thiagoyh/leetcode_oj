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
         int maxLeft = minDepth(root->left);
         int maxRight = minDepth(root->right);

         return 1 + std::min(maxLeft, maxRight);
    }
};