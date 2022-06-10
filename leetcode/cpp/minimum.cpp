#include <algorithm>
#include <limits.h>
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
    int max;
    int min;
};

class Solution {
public:
    int res = INT_MAX;
    TreeNode* pre;
    int getMinimumDifference(TreeNode* root) {
        process(root);
        return res;
    }

    void process(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        process(root->left);
        if (pre != nullptr) {
            res = (root->val - pre->val) < res ? (root->val - pre->val) : res;
        }
        pre = root;
        process(root->right);
    }
};