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
    TreeNode* searchBST(TreeNode* root, int val) {
        if (root == nullptr) {
            return nullptr;
        }
        if (root->val == val) {
            return root;
        }
        else if (root->val > val) {
            return searchBST(root->left, val);
        }
        else {
            return searchBST(root->right, val);
        }
    }
    TreeNode* search(TreeNode* root, int val) {
        while (root != nullptr) {
            if (root->val > val) {
                root = root->left;
            }
            else if (root->val < val) {
                root = root->right;
            }
            else return root;
        }
        return nullptr;
    }
};