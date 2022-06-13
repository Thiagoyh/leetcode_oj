
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
    TreeNode* parent;
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if (root == nullptr) {
            return new TreeNode(val);
        }
        process(root, val);
        return root;
    }

    void process(TreeNode* root, int val) {
        if (root == nullptr) {
            TreeNode* node = new TreeNode(val);
            if (val > parent->val) {
                parent->right = node;
            }
            else {
                parent->left = node;
            }
            return;
        }
        parent = root;
        if (val < root->val)
            process(root->left, val);
        if (val > root->val)
            process(root->right, val);
        return;
    }
};