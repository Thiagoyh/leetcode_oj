#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> partitionLabels(string s) {
        std::vector<int> res;
        if (s.size() == 0) {
            return res;
        }
        std::vector<int> end(26, 0);
        for(int i = s.size() - 1; i >= 0; i--) {
            if (end[s[i] - 'a'] != 0) {
                continue;
            }
            end[s[i] - 'a'] = i;
        }

        int start = 0;
        int right = 0;
        for (int i = 0; i < s.size(); ++i) {
            right = std::max(right, end[s[i] - 'a']);
            if (i == right) {
                res.push_back(right - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
};