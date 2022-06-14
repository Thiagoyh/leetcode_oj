

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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if (root == nullptr) {
            return root;
        }
        if (root->val == key) {
            if (root->left == nullptr && root->right == nullptr) {
                delete root;
                return nullptr;
            }
            if (root->left == nullptr) {
                TreeNode* node = root->right;
                delete root;
                return node;
            }
            if (root->right == nullptr) {
                TreeNode* node = root->left;
                delete root;
                return node;
            }
            TreeNode* cur = root->right;
            while (cur->left != nullptr) {
                cur = cur->left;
            }
            cur->left = root->left;
            TreeNode* node = root->right;
            delete root;
            return node;
        }
        if (root->val > key)
            root->left = deleteNode(root->left, key);
        if (root->val < key)
            root->right = deleteNode(root->right, key);
        return root;
    }
};