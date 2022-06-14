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
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        if (nums.size()) {
            return nullptr;
        }
        return process(nums, 0, nums.size());
    }
    TreeNode* process(std::vector<int>& nums, int begin, int end) {
        if (begin == end) {
            return nullptr;
        }
        if (end - begin == 1) {
            return new TreeNode(nums[begin]);
        }
        int max = nums[begin];
        int index = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode* root = new TreeNode(max);
        root->left = process(nums, begin, index);
        root->right = process(nums, index + 1, end);

        return root;
    }
};