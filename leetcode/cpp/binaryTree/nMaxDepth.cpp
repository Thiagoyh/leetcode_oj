#include <vector>
#include <queue>


class Node {
public:
    int val;
    std::vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, std::vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
public:
    int maxDepth(Node* root) {
        if (root == nullptr) {
            return 0;
        }
        std::queue<Node*> queue;
        queue.push(root);
        int res = 0;
        while (!queue.empty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                Node* node = queue.front();
                queue.pop();
                for (int j = 0; j < node->children.size(); ++j) {
                    if (node->children[j] != nullptr) {
                        queue.push(node->children[j]);
                    }
                }
            }
        }
        return res;
    }
    int process(Node* root) {
        if (root == nullptr) {
            return 0;
        }
        int size = root->children.size();
        int max = 0;
        for (int i = 0; i < size; i++) {
            int cur = process(root->children[i]);
            max = cur > max ? cur : max;
        }
        return 1 + max;
    }
};
