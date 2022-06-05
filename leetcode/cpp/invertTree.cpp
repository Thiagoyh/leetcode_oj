#include <stack>
#include <queue>


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
    TreeNode* invertTree(TreeNode* root) {
        TreeNode* cur = root;
        inoderTraversal(cur);
        return root;
    }
    void inoderTraversal(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        TreeNode* tmp = root->left;
        root->left = root->right;
        root->right = tmp;
        inoderTraversal(root->right);
        inoderTraversal(root->left);
    }

    TreeNode* invertTreePreIter(TreeNode* root) {
        if (root == nullptr) {
            return root;
        }
        std::stack<TreeNode*> stack;
        TreeNode* cur = root;
        stack.push(cur);
        while (!stack.empty()) {
            cur = stack.top();
            stack.pop();
            TreeNode* tmp = cur->left;
            cur->left = cur->right;
            cur->right = tmp;
            if (cur->left != nullptr)
                stack.push(cur->left);
            if (cur->right != nullptr)
                stack.push(cur->right);
        }
        return root;
    }
    TreeNode* invertTreeLevelIter(TreeNode* root) {
        if (root == nullptr) {
            return root;
        }
        std::queue<TreeNode*> queue;
        TreeNode* cur = root;
        queue.push(cur);
        while (!queue.empty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                cur = queue.front();
                queue.pop();
                TreeNode* tmp = cur->left;
                cur->left = cur->right;
                cur->right = tmp;
                if (cur->left != nullptr)
                   queue.push(cur->left);
                if (cur->right != nullptr)
                   queue.push(cur->right);
            }
        }
        return root;
    }
};