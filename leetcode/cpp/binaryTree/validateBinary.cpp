#include <algorithm>

#define INT_MAX 0x7fffffff
#define INT_MIN 0x80000000

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
    TreeNode(int val, TreeNode* left, TreeNode* right) :
             val(val), left(left), right(right) {}
};

struct Info {
    bool isBST;
    int max;
    int min;
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if (root == nullptr) {
            return true;
        }
        return process(root).isBST;
    }

    Info process(TreeNode* root) {
        if (root == nullptr) {
            return Info{true, -2147483648, INT_MAX};
        }
        Info leftInfo = process(root->left);
        Info rightInfo = process(root->right);

        int max = std::max(root->val, std::max(leftInfo.max, rightInfo.max));
        int min = std::min(root->val, std::min(leftInfo.min, rightInfo.min));

        bool isBST = false;
        if (root->val > leftInfo.max && root->val < rightInfo.min
           && leftInfo.isBST == true && rightInfo.isBST == true) {
            isBST = true;
        }
        if (root->left == nullptr && root->right == nullptr) {
            return Info{true, root->val, root->val};
        }
        if (root->left == nullptr && root->val < rightInfo.min && rightInfo.isBST == true) {
            isBST = true;
        }
        if (root->right == nullptr && root->val >leftInfo.max && leftInfo.isBST == true) {
            isBST = true;
        }

        return Info{isBST, max, min};
    }
};