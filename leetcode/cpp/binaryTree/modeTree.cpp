#include <vector>
#include <queue>

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
    TreeNode* pre = nullptr;
    std::vector<int> res;
    int count;
    int max;
    vector<int> findMode(TreeNode* root) {
        if (root == nullptr) {
            return res;
        }
        process(root);
        return res;
    }
    void process(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        process(root->left);
        if (pre == nullptr) {
            count = 1;
        }
        else {
            if (root->val == pre->val) {
                count++;
            }
            else {
                count = 1;
            }
        }
        pre = root;
        if (count == max) {
            res.push_back(root->val);
        }
        if (count > max) {
            max = count;
            res.clear();
            res.push_back(root->val);
        }
        process(root->right);
    }
};