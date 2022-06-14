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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.size() == 0) {
            return nullptr;
        }
        return process(nums, 0, nums.size());
    }
    TreeNode* process(std::vector<int>& nums, int begin, int end) {
        if (begin == end) {
            return nullptr;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = process(nums, begin, mid - 1);
        root->right = process(nums, mid + 1, end);

        return root;
    }
};