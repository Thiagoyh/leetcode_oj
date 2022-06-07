
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
int findBottomLeftValue(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        std::queue<TreeNode*> queue;
        queue.push(root);
        int res = 0;
        while (!queue.empty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode* cur = queue.front();
                queue.pop();
                if (i == 0) {
                    res = cur->val;
                }
                if (cur->left != nullptr) {
                    queue.push(cur->left);
                }
                if (cur->right != nullptr) {
                    queue.push(cur->right);
                }
            }
        }
        return res;
    }
};