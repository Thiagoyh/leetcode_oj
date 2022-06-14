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
    TreeNode* process(std::vector<int>& preorder, std::vector<int>& inorder,
                      int preBeigin, int preEnd, int inBegin, int inEnd) {
            if (preBeigin == preEnd) {
                return nullptr;
            }
            TreeNode* root = new TreeNode(preorder[preBeigin]);
            if (preEnd - preBeigin == 1) {
                return root;
            }

            int splitIndex = 0;
            for (int i = 0; i < inorder.size(); ++i) {
                if (inorder[i] == preorder[preBeigin]) {
                    splitIndex = i;
                    break;
                }
            }

            root->left = process(preorder, inorder, preBeigin + 1,
                         preBeigin + 1 + (splitIndex - inBegin), inBegin, splitIndex);
            root->right = process(preorder, inorder, preBeigin + 1 + (splitIndex - inBegin) + 1,
                          preEnd, splitIndex + 1, inEnd);
            return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
            if (preorder.size() == 0) {
                return nullptr;
            }
            return process(preorder, inorder, 0, preorder.size(), 0, inorder.size());
    }
};