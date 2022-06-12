#include <vector>
#include <queue>

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

struct temp {
    bool operator()(std::pair<int, int> a, std::pair<int, int> b) {
        return a.second < b.second;
    }
};
class Solution {
public:
    int pre = (1 << 6);
    vector<int> findMode(TreeNode* root) {
        std::vector<int> res;
        if (root == nullptr) {
            return res;
        }
        std::vector<int> nums;
        process(root, nums);
        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, temp> queue;
        int pre = nums[0];
        int count = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] == pre) {
                count++;
            }
            else {
                queue.push(std::pair<int, int>(pre, count));
                count = 1;
                pre = nums[i];
            }
        }
        queue.push(std::pair<int, int>(nums[nums.size() - 1], count));
        pre = queue.top().second;
        res.push_back(queue.top().first);
        queue.pop();
        while (!queue.empty()) {
            if (queue.top().second == pre) {
                res.push_back(queue.top().first);
                queue.pop();
            }
            else {
                break;
            }
        }
        return res;
    }
    void process(TreeNode* root, std::vector<int>& nums) {
        if (root == nullptr) {
            return;
        }
        process(root->left, nums);
        nums.push_back(root->val);
        process(root->right, nums);
    }
};