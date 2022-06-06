#include <iostream>
#include <cmath>

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
    int countNodes(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        return process(root);
    }

    int process(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftHeight = getHeight(root->left);
        int rightHeight = getHeight(root->right);
        if (leftHeight == rightHeight) {
            return 1 + std::pow(2, leftHeight) - 1 + process(root->right);
        }
        else {
            return 1 + std::pow(2, rightHeight) - 1 + process(root->left);
        }
    }

    int getHeight(TreeNode* root) {
        int height = 0;
        TreeNode* cur = root;
        while (cur != nullptr) {
            ++height;
            cur = cur->left;
        }
        return height;
    }
};