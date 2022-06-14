#include <stack>

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
    bool hasPathSum(TreeNode* root, int targetSum) {
         if (root == nullptr) {
             return false;
         }
         return preorderTraversal(root, targetSum - root->val);
    }

    bool preorderTraversal(TreeNode* root, int rest) {
         if (root->left == nullptr && root->right == nullptr && rest == 0) {
             return true;
         }
         if (root->left == nullptr && root->right == nullptr) {
             return false;
         }

         if (root->left) {
             rest -= root->left->val;
             if (preorderTraversal(root->left, rest)) {
                 return true;
             }
             rest += root->left->val;
         }
         if (root->right) {
             rest -= root->right->val;
             if (preorderTraversal(root->right, rest)) {
                 return true;
             }
             rest += root->right->val;
         }
         return false;
    }
};
