
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
    TreeNode* trimBST(TreeNode* root, int low, int high) {
        if (root == nullptr) {
            return nullptr;
        }
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        if (root->val > high) {
            TreeNode* node = root->left;
            deleteTree(root->right);
            return trimBST(left, low, high);
        }
        if (root->val < low) {
            TreeNode* node = root->right;
            deleteTree(root->left);
            return trimBST(right, low, high);
        }

        root->left = trimBST(left, low, high);
        root->right = trimBST(right, low, high);

        return root;
    }
    void deleteTree(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        TreeNode* left = root->left;
        TreeNode* right = root->right;

        delete root;
        deleteTree(left);
        deleteTree(right);
    }
};