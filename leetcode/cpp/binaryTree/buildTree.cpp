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
    TreeNode* process(vector<int>& inorder, vector<int>& postorder,
              int inorderBegin, int inorderEnd, int postorderBegin, int postorderEnd) {
        if (postorderBegin == postorderEnd) {
            return nullptr;
        }
        TreeNode* root = new TreeNode(postorder[postorderEnd - 1]);
        if (postorderEnd - postorderBegin == 1) {
            return root;
        }

        int split = 0;
        for (int i = 0; i < inorder.size(); ++i) {
            if (inorder[i] == postorder[postorderEnd - 1]) {
                split = i;
                break;
            }
        }

        root->left = process(inorder, postorder,
           inorderBegin, split, postorderBegin, postorderBegin + (split - inorderBegin));
        root->right = process(inorder, postorder,
           split + 1, inorderEnd, postorderBegin + (split - inorderBegin) + 1, postorderEnd);
        return root;
    }
};