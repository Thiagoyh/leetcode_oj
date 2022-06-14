#include <iostream>
#include <queue>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

struct Info {
    int height;
    bool isBalanced;
};

class Solution {
public:
    bool isBalanced(TreeNode* root) {
         if (root == nullptr) {
             return true;
         }
         Info info = process(root);
         return info.isBalanced;
    }

    Info process(TreeNode* root) {
        if (root == nullptr) {
            return Info{0, true};
        }
        Info leftInfo = process(root->left);
        Info rightInfo = process(root->right);

        int height = 1 + std::max(leftInfo.height, rightInfo.height);
        bool isBalanced = std::abs(leftInfo.height - rightInfo.height) <= 1 ?
                          true : false;
        return Info{height, isBalanced && leftInfo.isBalanced && rightInfo.isBalanced};
    }
};