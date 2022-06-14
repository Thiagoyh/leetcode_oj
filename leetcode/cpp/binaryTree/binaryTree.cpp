#include <iostream>
#include <vector>
#include <queue>
#include <stack>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class BinaryTreeTraveral
{
public:
    // 使用数组创建二叉树
    TreeNode *createTreeByLevel(std::vector<int>& nums) {
        int len = nums.size();
        if (len == 0) {
            return nullptr;
        }
        std::queue<TreeNode *> queue;
        int index = 0;
        TreeNode *root = new TreeNode(nums[index++]);
        queue.push(root);
        TreeNode *p = nullptr;
        while (!queue.empty() && index < len) {
            p = queue.front();
            queue.pop();
            if (nums[index] != -1) {
                TreeNode *leftNode = new TreeNode(nums[index]);
                p->left = leftNode;
                queue.push(leftNode);
            }
            index++;
            if (index < len && nums[index] != -1) {
                TreeNode *rightNode = new TreeNode(nums[index]);
                p->right = rightNode;
                queue.push(rightNode);
            }
            index++;
        }
        return root;
    }
    // 先序序列构造二叉树
    void createTree(TreeNode* root, std::vector<int>& nums, int& index) {
         if (nums[index] == -1) {
             index++;
             root = nullptr;
         }
         else {
             std::cout << nums[index] << std::endl;
             root = new TreeNode(nums[index++]);
             createTree(root->left, nums, index);
             createTree(root->right, nums, index);
         }
    }
    void preOrdertraveral(TreeNode* head) {
         if (head == nullptr) {
             return;
         }
         std::cout << head->val << " ";
         preOrdertraveral(head->left);
         preOrdertraveral(head->right);
    }
    void preOrdertraveralIter(TreeNode* head) {
        if (head == nullptr) {
            return;
        }
        std::stack<TreeNode *> stack;
        stack.push(head);
        while (!stack.empty()) {
            TreeNode *cur = stack.top();
            stack.pop();
            std::cout << cur->val;
            if (cur->right != nullptr)
                stack.push(cur->right);
            if (cur->left != nullptr)
                stack.push(cur->left);
        }
    }
    void inOrdertraveralIter(TreeNode* head) {
        if (head == nullptr) {
            return;
        }
        std::stack<TreeNode *> stack;
        TreeNode *cur = head;
        while (cur != nullptr || !stack.empty()) {
            if (cur != nullptr) {
                stack.push(cur);
                cur = cur->left;
            }
            else {
                cur = stack.top();
                stack.pop();
                std::cout << cur->val << std::endl;
                cur = cur->right;
            }
        }
    }

    void inOrder(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        std::stack<TreeNode*> stack;
        TreeNode* cur = root;
        while (cur != nullptr || !stack.empty()) {
            if (cur != nullptr) {
                stack.push(cur->left);
                cur = cur->left;
            }
            else {
                cur = stack.top();
                stack.pop();
                //
                cur = cur->right;
            }
        }
    }
    // 后序有两种方式 1. 先序遍历收集之后逆序
    //              2. 收集栈
    void postOrdertraveralIter(TreeNode* head) {
        if (head == nullptr) {
            return;
        }
        std::stack<TreeNode *> stack;
        std::stack<TreeNode *> res;
        stack.push(head);
        while (!stack.empty()) {
            TreeNode *cur = stack.top();
            stack.pop();
            res.push(cur);
            if (cur->left != nullptr)
                stack.push(cur->left);
            if (cur->right != nullptr)
                stack.push(cur->right);
        }
        // 最后存在res中弹出即可
        while (!res.empty()) {
            TreeNode *cur = res.top();
            res.pop();
            std::cout << cur->val << std::endl;
        }
    }

    void inOrderTraversal(TreeNode* root) {
        std::stack<TreeNode *> stack;
        if (root != nullptr)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode* node = stack.top();
            if (node != nullptr) {
                stack.pop();
                if (node->right != nullptr)
                    stack.push(node->right);
                stack.push(node);
                stack.push(nullptr);
                if (node->left != nullptr)
                    stack.push(node->left);
            }else {
                stack.pop();
                node = stack.top();
                stack.pop();
                std::cout << node->val << std::endl;
            }
        }
    }

    void preOrderTraversal(TreeNode* root) {
        std::stack<TreeNode *> stack;
        if (root != nullptr)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode* node = stack.top();
            if (node != nullptr) {
                stack.pop();
                if (node->right != nullptr)
                    stack.push(node->right);
                if (node->left != nullptr)
                    stack.push(node->left);
                stack.push(node);
                stack.push(nullptr);
            }else {
                stack.pop();
                node = stack.top();
                stack.pop();
                std::cout << node->val << std::endl;
            }
        }
    }

    void postOrderTraversal(TreeNode* root) {
        std::stack<TreeNode *> stack;
        if (root != nullptr)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode* node = stack.top();
            if (node != nullptr) {
                stack.pop();
                stack.push(node);
                stack.push(nullptr);
                if (node->right != nullptr)
                    stack.push(node->right);
                if (node->left != nullptr)
                    stack.push(node->left);
            }else {
                stack.pop();
                node = stack.top();
                stack.pop();
                std::cout << node->val << std::endl;
            }
        }
    }
};

int main() {
    std::vector<int> nums = {15, 11, 8, -1, -1, 14, 13, -1, -1, -1, 20, -1, -1};
    BinaryTreeTraveral traveral;
    TreeNode *root;
    int index = 0;
    traveral.createTree(root, nums, index);
    return 0;
}