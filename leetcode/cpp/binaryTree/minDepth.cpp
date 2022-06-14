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
         std::queue<TreeNode*> queue;
         int res = 0;
         queue.push(root);

         while (!queue.empty()) {
             int size = queue.size();
             res++;
             for (int i = 0; i < size; i++) {
                 TreeNode* node = queue.front();
                 queue.pop();
                 if (node->left == nullptr && node->right == nullptr) {
                     return res;
                 }
                 if (node->left != nullptr) {
                     queue.push(node->left);
                 }
                 if (node->right != nullptr) {
                     queue.push(node->right);
                 }
             }
         }
         return res;
    }
    int process(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int left = process(root->left);
        int right = process(root->right);

        if (root->left == nullptr && root->right != nullptr) {
            return 1 + right;
        }
        if (root->left != nullptr && root->right == nullptr) {
            return 1 + left;
        }

        return (1 + std::min(left, right));
    }
};