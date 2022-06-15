#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<vector<string>> partition(string s) {
        std::vector<std::vector<std::string>> res;
        if (s.size() == 0) {
            return res;
        }
        std::vector<std::string> part;
        process(res, part, s, 0);
        return res;
    }
    void process(std::vector<std::vector<std::string>>& res, std::vector<std::string>& part,
                 std::string& s, int index) {
        if (index == s.size()) {
            res.push_back(part);
            return;
        }
        for (int i = 1; i <= s.size() - index; i++) {
            std::string str = s.substr(index, i);
            if (!isPalindrome(str)) continue;
            part.push_back(s.substr(index, i));
            process(res, part, s, index + i);
            part.pop_back();
        }
    }
    bool isPalindrome(string& s) {
        int l = 0, r = s.size() - 1;
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
};