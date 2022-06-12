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
    vector<int> findMode(TreeNode* root) {
        std::vector<int> nums;
        process(root, nums);

    }
    void process(TreeNode* root, std::vector<int>& res) {
        if (root == nullptr) {
            return;
        }
        process(root->left, res);
        res.push_back(root->val);
        process(root->right, res);
    }
};