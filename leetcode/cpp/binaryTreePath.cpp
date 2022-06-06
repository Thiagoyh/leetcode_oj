#include <vector>
#include <string>
#include <stack>

using namespace std;

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
    vector<string> binaryTreePaths(TreeNode* root) {
        std::vector<std::string> res;
        std::vector<int> path;
        inorderTraversal(root, path, res);
        return res;
    }
    void inorderTraversal(TreeNode* root, std::vector<int> path, std::vector<string>& res) {
        if (root->left == nullptr && root->right == nullptr) {
            path.push_back(root->val);
            std::string sPath;
            for (int i = 0; i < path.size() - 1; ++i) {
                sPath += std::to_string(path[i]);
                sPath += "->";
            }
            sPath += to_string(path[path.size() - 1]);
            res.push_back(sPath);
            return;
        }

        path.push_back(root->val);

        if(root->left != nullptr) {
            inorderTraversal(root->left, path, res);
            path.pop_back();
        }
        if (root->right != nullptr) {
            inorderTraversal(root->right, path, res);
            path.pop_back();
        }
    }
};