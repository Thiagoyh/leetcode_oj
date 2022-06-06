#include <stack>
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
    int sumOfLeftLeaves(TreeNode* root) {
       if (root == nullptr) {
           return 0;
       }
       if (root->left == nullptr && root->right == nullptr) {
           return 0;
       }
       int sum = 0;
       levelTraversal(root, sum);
       return sum;
    }

    void levelTraversal(TreeNode* root, int& sum) {
       std::queue<TreeNode*> queue;
       queue.push(root);

       while (!queue.empty()) {
           TreeNode* cur = queue.front();
           queue.pop();
           if (cur->left != nullptr && cur->left->left == nullptr
              && cur->left->right == nullptr) {
                  sum += cur->left->val;
              }
            if (cur->left != nullptr) {
                queue.push(cur->left);
            }
            if (cur->right != nullptr) {
                queue.push(cur->right);
            }
       }
    }
};