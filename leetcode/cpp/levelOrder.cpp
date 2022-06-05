#include <iostream>
#include <queue>
#include <stack>
#include <vector>

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
    std::vector<std::vector<int>> levelOrder(TreeNode* root) {
        std::vector<std::vector<int>> res;
        if (root == nullptr) {
            return res;
        }
        std::queue<TreeNode*> queue;
        queue.push(root);
        while (!queue.empty()) {
            std::vector<int> res_level;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode* cur = queue.front();
                queue.pop();
                res_level.push_back(cur->val);
                if (cur->left != nullptr)
                    queue.push(cur->left);
                if (cur->right != nullptr)
                    queue.push(cur->right);
            }
            res.push_back(res_level);
        }
        return res;
    }

    bool process(TreeNode* left, TreeNode* right) {
        if (left == nullptr && right == nullptr) return true;
        else if (left != nullptr && right == nullptr) return false;
        else if (left == nullptr && right != nullptr) return false;
        else if (left->val != right->val) return false;

        else {
            bool outside = process(left->left, right->right);
            bool inside = process(left->right, right->left);
            return (outside && inside);
        }
    }

    bool isSymmetric(TreeNode* root) {
          if (root == nullptr) {
              return true;
          }
          std::queue<TreeNode*> queue;
          queue.push(root->left);
          queue.push(root->right);

          while (!queue.empty()) {
              TreeNode* left = queue.front();
              queue.pop();
              TreeNode* right = queue.front();
              queue.pop();

              if (left == nullptr && right == nullptr) {
                  continue;
              }

              if ((left == nullptr || right == nullptr) ||
                  (left->val != right->val)) {
                      return false;
                  }
               queue.push(left->left);
               queue.push(right->right);
               queue.push(left->right);
               queue.push(right->left);
          }
          return true;
     }


};